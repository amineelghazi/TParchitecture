package com.example.demoef.controller;

import com.example.demoef.entity.Offre;
import com.example.demoef.service.OffresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voyageur/offres")
public class OffresVoyageurController {
    private final OffresService offresService;

    public OffresVoyageurController(OffresService offresService){
        this.offresService = offresService;
    }

    @GetMapping("/all")
    public List<Offre> lire(){
        return offresService.getAllOffres();
    }

    @GetMapping("/prix_min")
    public double prixMin(){
        return offresService.getPrixMin();
    }

    @GetMapping("/prix_max")
    public double prixMax(){
        return offresService.getPrixMax();
    }

    @GetMapping("/comparer")
    public List<Offre> comparer(@RequestParam double min, @RequestParam double max){
        return offresService.comparerPrix(min, max);
    }

}
