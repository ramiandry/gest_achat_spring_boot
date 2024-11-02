package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ArticleDto;
import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.repository.ArticleRepository;
import com.gest_achats.gest_achat.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private DemandeRepository demandeRepository;
    @Override
    public List<ArticleDto> getArticles() {
        return this.articleRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ArticleDto> create(Article article, Long id) {
        article.setDemande(this.demandeRepository.findById(id).get());
        this.articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.articleRepository.findById(article.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<ArticleDto> edit(Article article, Long id) {
        Article articles=this.articleRepository.findById(id).get();
        articles.setPrix_unitaire(article.getPrix_unitaire());
        articles.setDescription(article.getDescription());
        articles.setQuantite_demande(article.getQuantite_demande());
        this.articleRepository.save(articles);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.articleRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public List<ArticleDto> getById(Long id) {

        return this.articleRepository.findByDemande(this.demandeRepository.findById(id).get()).stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ArticleDto> editCommande(int commande, Long id) {
        Article articles=this.articleRepository.findById(id).get();
        articles.setQuantite_commande(commande);
        this.articleRepository.save(articles);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.articleRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<ArticleDto> editQuantite(int quantite, Long id) {
        Article articles=this.articleRepository.findById(id).get();
        articles.setQuantite(quantite);
        this.articleRepository.save(articles);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.articleRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public String delete(Long id) {
        this.articleRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public ArticleDto convertToEntite(Article article) {
        ArticleDto articleDto=new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setDate(article.getDemande().getDate());
        articleDto.setDemandeId(article.getDemande().getId());
        articleDto.setQuantite_commande(article.getQuantite_commande());
        articleDto.setQuantite(article.getQuantite());
        articleDto.setDescription(article.getDescription());
        articleDto.setPrix_unitaire(article.getPrix_unitaire());
        articleDto.setQuantite_demande(article.getQuantite_demande());
        return articleDto;
    }
}
