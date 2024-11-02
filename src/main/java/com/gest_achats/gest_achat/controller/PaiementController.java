package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.PaiementDto;
import com.gest_achats.gest_achat.model.Paiement;
import com.gest_achats.gest_achat.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("getAll")
    public List<PaiementDto> get() {
        return this.paiementService.get();
    }

    @PostMapping("create")
    public ResponseEntity<Paiement> create(@RequestBody final Paiement paiement) {
        return this.paiementService.create(paiement);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.paiementService.delete(id);
    }
}
