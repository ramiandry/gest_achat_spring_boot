package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.DemandeDto;
import com.gest_achats.gest_achat.model.Demande;
import com.gest_achats.gest_achat.service.DemandeService;
import com.gest_achats.gest_achat.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/demande")
public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @Autowired
    private FileStorageService storageService;

    @Value("${project.image}")
    private  String path;

    @GetMapping("getAll")
    public List<DemandeDto> getArticles() {
        return this.demandeService.get();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<DemandeDto> download(@PathVariable Long id) {
        return this.demandeService.getById(id);
    }

    @PostMapping(value = "create/{id}")
    public ResponseEntity<DemandeDto> create(@RequestBody final Demande demande, @PathVariable Long id) throws IOException {
        return this.demandeService.create(demande, id);
    }

    @PostMapping(value = "edit/{id}")
    public ResponseEntity<DemandeDto> edit(@RequestBody final Demande demande, @PathVariable Long id) throws IOException {
        return this.demandeService.edit(demande, id);
    }

    @PostMapping(value = "editQuantite/{id}")
    public ResponseEntity<DemandeDto> editQuantite(@RequestBody final Demande demande, @PathVariable Long id) throws IOException {
        return this.demandeService.validQuantite(demande, id);
    }

    @PostMapping(value = "editBudget/{id}")
    public ResponseEntity<DemandeDto> editBudget(@RequestBody final Demande demande, @PathVariable Long id) throws IOException {
        return this.demandeService.validBudget(demande,id);
    }

    @PostMapping("testing")
    public String testing(@RequestParam("fiche") MultipartFile fiche)  {

        return fiche.getOriginalFilename();
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        this.demandeService.delete(id);
        return "delete succesfully !!";
    }

}