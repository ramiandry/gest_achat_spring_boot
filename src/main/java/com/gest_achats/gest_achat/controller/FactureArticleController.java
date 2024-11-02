package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.FactureArticleDto;
import com.gest_achats.gest_achat.model.FactureArticle;
import com.gest_achats.gest_achat.service.FactureArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/facture_article")
public class FactureArticleController {

    @Autowired
    private FactureArticleService factureArticleService;

    @GetMapping("getAll")
    public List<FactureArticleDto> get() {
        return this.factureArticleService.get();
    }

    @PostMapping("create")
    public ResponseEntity<FactureArticleDto> create(@RequestBody final FactureArticle factureArticle) {
        return this.factureArticleService.create(factureArticle);
    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.factureArticleService.delete(id);
    }
}
