package com.example.demoef.service;

import com.example.demoef.entity.Offre;
import com.example.demoef.entity.Operateur;
import com.example.demoef.entity.Vol;
import com.example.demoef.repository.OffreRepository;
import com.example.demoef.repository.OperateurRepository;
import com.example.demoef.repository.VolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffresService {

    private OffreRepository offreRepository;
    private VolRepository volRepository;
    private OperateurRepository operateurRepository;

    public OffresService(OffreRepository offreRepository, VolRepository volRepository, OperateurRepository operateurRepository){
        this.offreRepository = offreRepository;
        this.volRepository = volRepository;
        this.operateurRepository = operateurRepository;
    }

    public List<Offre> getAllOffres(){
        return offreRepository.findAll();
    }

    public Offre createOffre(int id, int volId, int operateurId, String depart, double prixBase) {
        Optional<Vol> optionalVol = volRepository.findById(volId);
        Optional<Operateur> optionalOperateur = operateurRepository.findById(operateurId);

        if (optionalVol.isEmpty()) {
            throw new IllegalArgumentException("Le vol n'existe pas.");
        }
        if (optionalOperateur.isEmpty()) {
            throw new IllegalArgumentException("L'opérateur n'existe pas.");
        }
        Offre newOffre = new Offre();
        newOffre.setId(id);
        newOffre.setTrajet(optionalVol.get());
        newOffre.setOperateur(optionalOperateur.get());
        newOffre.setDepart(depart);
        newOffre.setPrixBase(prixBase);
        return newOffre;
    }

    public Offre getOffreById(int id) {
        return offreRepository.findById(id).orElse(null);
    }

    public Offre updateOffre(int id, int trajetId, int operateurId, String depart, double prixBase) {
        Optional<Offre> optionalOffre = offreRepository.findById(id);
        Optional<Vol> optionalVol = volRepository.findById(trajetId);
        Optional<Operateur> optionalOperateur = operateurRepository.findById(operateurId);

        if (optionalOffre.isEmpty() || optionalVol.isEmpty() || optionalOperateur.isEmpty()) {
            return null;
        }

        Offre offre = optionalOffre.get();
        offre.setTrajet(optionalVol.get());
        offre.setOperateur(optionalOperateur.get());
        offre.setDepart(depart);
        offre.setPrixBase(prixBase);

        return offre;
    }

    public boolean deleteOffre(int id) {
        if(offreRepository.findById(id).isPresent()) {
            offreRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public double getPrixMin() {
        return getAllOffres().stream().mapToDouble(Offre::getPrixBase).min().orElse(0);
    }
    public double getPrixMax() {
        return getAllOffres().stream().mapToDouble(Offre::getPrixBase).max().orElse(0);
    }
    public List<Offre> comparerPrix(double min, double max) {
        return getAllOffres().stream()
                .filter(o -> o.getPrixBase() >= min && o.getPrixBase() <= max)
                .toList();
    }
}
