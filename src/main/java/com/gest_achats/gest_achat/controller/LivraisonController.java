package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.LivraisonDto;
import com.gest_achats.gest_achat.model.Livraison;
import com.gest_achats.gest_achat.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/livraison")
public class LivraisonController {

    @Autowired
    private LivraisonService livraisonService;

    @GetMapping("getAll")
    public List<LivraisonDto> get() {
        return this.livraisonService.get();
    }

    @PostMapping("create")
    public ResponseEntity<LivraisonDto> create(@RequestBody final Livraison livraison) {
       return this.livraisonService.create(livraison);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.livraisonService.delete(id);
    }
}
