package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.model.ReceptionArticle;
import com.gest_achats.gest_achat.repository.ArticleRepository;
import com.gest_achats.gest_achat.repository.ReceptionArticleRepository;
import com.gest_achats.gest_achat.repository.ReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.gest_achats.gest_achat.dto.ReceptionArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptionArticleServiceImp implements ReceptionArticleService{
    @Autowired
    private ReceptionArticleRepository receptionArticleRepository;

    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ReceptionArticleDto> get() {
        return this.receptionArticleRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public List<ReceptionArticleDto> getByReception(Long reception) {

        return this.receptionArticleRepository.findByReception(this.receptionRepository.findById(reception).get())
                .stream().map(this::convertToEntite).collect(Collectors.toList());
    }

   /* @Override
    public ResponseEntity<ReceptionArticleDto> getByReceptionArticle(Reception reception, Article article) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.receptionArticleRepository.findByReceptionArticle(this.receptionRepository.findById(reception.getId()).get()
                        ,this.articleRepository.findById(article.getId()).get()).map(this::convertToEntite).get());
    }*/

    @Override
    public ResponseEntity<ReceptionArticleDto> create(ReceptionArticle receptionArticle) {
        receptionArticle.setReception(this.receptionRepository.findById(receptionArticle.getReception().getId()).get());
        receptionArticle.setArticle(this.articleRepository.findById(receptionArticle.getArticle().getId()).get());
        this.receptionArticleRepository.save(receptionArticle);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.receptionArticleRepository.findById(receptionArticle.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<ReceptionArticleDto> edit(ReceptionArticle receptionArticle, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.receptionArticleRepository.deleteById(id);
        return "delete success";
    }


    @Override
    public ReceptionArticleDto convertToEntite(ReceptionArticle receptionArticle) {
        ReceptionArticleDto receptionArticleDto=new ReceptionArticleDto();
        receptionArticleDto.setId_article(receptionArticle.getArticle().getId());
        receptionArticleDto.setDescription(receptionArticle.getArticle().getDescription());
        receptionArticleDto.setQuantite(receptionArticle.getArticle().getQuantite());
        receptionArticleDto.setQuantite_demande(receptionArticle.getArticle().getQuantite_demande());
        receptionArticleDto.setPrix_unitaire(receptionArticle.getArticle().getPrix_unitaire());
        receptionArticleDto.setDemandeId(receptionArticle.getArticle().getDemande().getId());
        receptionArticleDto.setDate_demande(receptionArticle.getArticle().getDemande().getDate());
        receptionArticleDto.setQuantite_commande(receptionArticle.getArticle().getQuantite_commande());
        receptionArticleDto.setId_reception(receptionArticle.getReception().getId());
        receptionArticleDto.setDate_reception(receptionArticle.getReception().getDate());
        receptionArticleDto.setReceptionniste(receptionArticle.getReception().getReceptionniste().getNom());
        receptionArticleDto.setEmplacement(receptionArticle.getReception().getEmplacement());
        receptionArticleDto.setId_livraison(receptionArticle.getReception().getLivraison().getId());
        receptionArticleDto.setDate_livraison(receptionArticle.getReception().getLivraison().getDate());
        receptionArticleDto.setStatus(receptionArticle.getReception().getLivraison().getStatus());
        receptionArticleDto.setId_user(receptionArticle.getReception().getUtilisateur().getId());
        receptionArticleDto.setNom(receptionArticle.getReception().getUtilisateur().getNom_utilisateur());
        receptionArticleDto.setQuantite_recu(receptionArticle.getRecu());
        receptionArticleDto.setFournisseur(receptionArticle.getReception().getLivraison().getCommande().getFournisseur().getNom());
        return receptionArticleDto;
    }
}
