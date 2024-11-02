package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.FournisseurDto;
import com.gest_achats.gest_achat.model.Fournisseur;
import com.gest_achats.gest_achat.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("getAll")
    public List<FournisseurDto> get() {
        return this.fournisseurService.get();
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<FournisseurDto> getById(@PathVariable("id") Long id) {
        return this.fournisseurService.getById(id);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<FournisseurDto> edit(@RequestBody Fournisseur fournisseur, @PathVariable("id") Long id) {
        return this.fournisseurService.edit(fournisseur,id);
    }

    @PostMapping("create")
    public ResponseEntity<FournisseurDto> create(@RequestBody final Fournisseur fournisseur) {
        return this.fournisseurService.create(fournisseur);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.fournisseurService.delete(id);
    }
}
