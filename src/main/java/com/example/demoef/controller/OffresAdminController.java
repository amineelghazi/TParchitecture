package com.example.demoef.controller;

import com.example.demoef.entity.Offre;
import com.example.demoef.service.OffresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/offres")
public class OffresAdminController {

    private final OffresService offresService;

    public OffresAdminController (OffresService offresService){
        this.offresService = offresService;
    }

    // CRUD
    @GetMapping("/all")
    public List<Offre> read(){
        return offresService.getAllOffres();
    }

    @GetMapping("/create")
    public ResponseEntity<Offre> createOffre(
            @RequestParam int id,
            @RequestParam int trajetId,
            @RequestParam int operateurId,
            @RequestParam String depart,
            @RequestParam double prixBase
    ) {
        return ResponseEntity.ok(
                offresService.createOffre(id, trajetId, operateurId, depart, prixBase)
        );
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Offre> updateOffre(
            @PathVariable int id,
            @RequestParam int trajetId,
            @RequestParam int operateurId,
            @RequestParam String depart,
            @RequestParam double prixBase
    ) {
        return ResponseEntity.ok(
                offresService.updateOffre(id, trajetId, operateurId, depart, prixBase)
        );
    }

    @GetMapping("/delete/{id}")
    public Object deleteOffre(@PathVariable int id) {
        return offresService.deleteOffre(id);
    }
}

