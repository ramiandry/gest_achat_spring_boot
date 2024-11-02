package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.ArticleDto;
import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("getAll")
    public List<ArticleDto> getArticles(){
        return this.articleService.getArticles();
    }

    @PostMapping("create/{id}")
    public ResponseEntity<ArticleDto> create(@RequestBody final Article article, @PathVariable("id") Long id){
        return this.articleService.create(article, id);
    }


    @PostMapping("edit/{id}")
    public ResponseEntity<ArticleDto> edit(@RequestBody final Article article, @PathVariable("id") Long id){
        return this.articleService.edit(article, id);
    }

    @PostMapping("editCommande/{id}")
    public ResponseEntity<ArticleDto> editCommande(@RequestBody final Article article, @PathVariable("id") Long id){
        return this.articleService.editCommande(article.getQuantite_commande(), id);
    }

    @PostMapping("editQuantite/{id}")
    public ResponseEntity<ArticleDto> editQuantite(@RequestBody final Article article, @PathVariable("id") Long id){
        System.out.println(article.getQuantite()+" "+id);
        return this.articleService.editQuantite(article.getQuantite(), id);
    }


    @GetMapping("getDemande/{id}")
    public List<ArticleDto> getById(@PathVariable("id") Long id) {
        return this.articleService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.articleService.delete(id);
    }

}
