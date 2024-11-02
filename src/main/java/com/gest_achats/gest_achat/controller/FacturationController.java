package com.gest_achats.gest_achat.controller;


import com.gest_achats.gest_achat.dto.FactureDto;
import com.gest_achats.gest_achat.model.Facturation;
import com.gest_achats.gest_achat.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/facture")
public class FacturationController {

    @Autowired
    private FactureService factureService;

    @GetMapping("getAll")
    public List<FactureDto> get() {
        return this.factureService.get();
    }

    @PostMapping("create")
    public ResponseEntity<FactureDto> create(@RequestBody final Facturation facturation) {
        return this.factureService.create(facturation);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.factureService.delete(id);
    }
}
