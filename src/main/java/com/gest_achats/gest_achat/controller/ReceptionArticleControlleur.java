package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.ReceptionArticleDto;
import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.model.ReceptionArticle;
import com.gest_achats.gest_achat.service.ReceptionArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reception_article")
public class ReceptionArticleControlleur {

    @Autowired
    private ReceptionArticleService receptionArticleService;

    @GetMapping("getAll")
    public List<ReceptionArticleDto> get() {
        return this.receptionArticleService.get();
    }

    @GetMapping("getByReception/{id}")
    public List<ReceptionArticleDto> getByReception(@PathVariable("id") Long reception) {
        return this.receptionArticleService.getByReception(reception);
    }

  /*  @GetMapping("getByReceptionArticle")
    public  ResponseEntity<ReceptionArticleDto> getByReceptionArticle(Reception reception, Article article) {
        return this.receptionArticleService.getByReceptionArticle(reception, article);
    }*/

    @PostMapping("create")
    public ResponseEntity<ReceptionArticleDto> create(@RequestBody final ReceptionArticle reception) {
        return this.receptionArticleService.create(reception);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.receptionArticleService.delete(id);
    }
}

