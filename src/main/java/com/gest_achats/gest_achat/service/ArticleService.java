package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ArticleDto;
import com.gest_achats.gest_achat.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ArticleService {

    public List<ArticleDto> getArticles();
    public ResponseEntity<ArticleDto> create(Article article, Long id);
    public ResponseEntity<ArticleDto> edit(Article article, Long id);
    public List<ArticleDto> getById(Long id);
    public ResponseEntity<ArticleDto> editCommande(int commande, Long id);
    public ResponseEntity<ArticleDto> editQuantite(int quantite, Long id);
    public String delete(Long id);
    public ArticleDto convertToEntite(Article article);


}
