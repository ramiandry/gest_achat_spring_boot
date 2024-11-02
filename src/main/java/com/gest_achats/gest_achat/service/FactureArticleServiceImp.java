package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FactureArticleDto;
import com.gest_achats.gest_achat.model.FactureArticle;
import com.gest_achats.gest_achat.repository.ArticleRepository;
import com.gest_achats.gest_achat.repository.FacturationRepository;
import com.gest_achats.gest_achat.repository.FactureArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureArticleServiceImp implements FactureArticleService{

    @Autowired
    private FactureArticleRepository factureArticleRepository;

    @Autowired
    private FacturationRepository facturationRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<FactureArticleDto> get() {
        return this.factureArticleRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<FactureArticleDto> create(FactureArticle factureArticle) {
        factureArticle.setFacturation(this.facturationRepository.findById(factureArticle.getFacturation().getId()).get());
        factureArticle.setArticle(this.articleRepository.findById(factureArticle.getArticle().getId()).get());
        this.factureArticleRepository.save(factureArticle);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.factureArticleRepository.findById(factureArticle.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<FactureArticleDto> edit(FactureArticleDto factureArticleDto, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.factureArticleRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public FactureArticleDto convertToEntite(FactureArticle factureArticle) {
        FactureArticleDto factureArticleDto=new FactureArticleDto();
        factureArticleDto.setId(factureArticle.getFacturation().getId());
        factureArticleDto.setDate_facture(factureArticle.getFacturation().getDate());
        factureArticleDto.setId_commande(factureArticle.getFacturation().getCommande().getId());
        factureArticleDto.setId_article(factureArticle.getArticle().getId());
        factureArticleDto.setDescription(factureArticle.getArticle().getDescription());
        factureArticleDto.setQuantite_demande(factureArticle.getArticle().getQuantite_demande());
        factureArticleDto.setDemandeId(factureArticle.getFacturation().getCommande().getDemande().getId());
        factureArticleDto.setTva(factureArticle.getTva());
        factureArticleDto.setPrix_unitaire(factureArticle.getArticle().getPrix_unitaire());
        factureArticleDto.setId_reception(factureArticle.getFacturation().getReception().getId());
        return factureArticleDto;
    }
}
