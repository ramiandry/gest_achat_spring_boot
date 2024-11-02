package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.DepartementDto;
import com.gest_achats.gest_achat.model.Departement;
import com.gest_achats.gest_achat.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/departement")

public class DepartementController {
    @Autowired
    private DepartementService departementService;

    @GetMapping("getAll")
    public List<DepartementDto> get() {
        return this.departementService.get();
    }

    @PostMapping("create")
    public ResponseEntity<Departement> create(@RequestBody final Departement departement) {
        return this.departementService.create(departement);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.departementService.delete(id);
    }
}
