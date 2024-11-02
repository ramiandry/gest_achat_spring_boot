package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.CommandeArticleDto;
import com.gest_achats.gest_achat.model.CommandeArticle;
import com.gest_achats.gest_achat.service.CommandeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/commande_article")
public class CommandeArticleController {
    @Autowired
    private CommandeArticleService commandeArticleService;

    @GetMapping("getAll")
    public List<CommandeArticleDto> getCommandeArticle() {
        return this.commandeArticleService.get();
    }

    @GetMapping("getByCommande/{id}")
    public List<CommandeArticleDto> getByCommande(@PathVariable("id") Long id) {
        return this.commandeArticleService.getByCommande(id);
    }

    @PostMapping("create")
    public ResponseEntity<CommandeArticleDto> create(@RequestBody final CommandeArticle commandeArticle) {
        return this.commandeArticleService.create(commandeArticle);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.commandeArticleService.delete(id);
    }

}
