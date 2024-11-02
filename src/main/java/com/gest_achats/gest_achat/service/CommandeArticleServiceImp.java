package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.CommandeArticleDto;
import com.gest_achats.gest_achat.model.CommandeArticle;
import com.gest_achats.gest_achat.repository.ArticleRepository;
import com.gest_achats.gest_achat.repository.CommandeArticleRepository;
import com.gest_achats.gest_achat.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeArticleServiceImp implements CommandeArticleService{
    @Autowired
    private CommandeArticleRepository commandeArticleRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<CommandeArticleDto> get() {
        return this.commandeArticleRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public List<CommandeArticleDto> getByCommande(Long id) {
        return this.commandeArticleRepository.findByCommande(this.commandeRepository.findById(id).get())
                .stream().map(this::convertToEntite).collect(Collectors.toList());
    }


    @Override
    public ResponseEntity<CommandeArticleDto> create(CommandeArticle commandeArticle) {
        commandeArticle.setCommande(this.commandeRepository.findById(commandeArticle.getCommande().getId()).get());
        commandeArticle.setArticle(this.articleRepository.findById(commandeArticle.getArticle().getId()).get());
        this.commandeArticleRepository.save(commandeArticle);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.commandeArticleRepository.findById(commandeArticle.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<CommandeArticle> edit(CommandeArticle commandeAritcle, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.commandeArticleRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public CommandeArticleDto convertToEntite(CommandeArticle commandeArticle) {
        CommandeArticleDto commandeArticleDto=new CommandeArticleDto();
        commandeArticleDto.setId(commandeArticle.getCommande().getId());
        commandeArticleDto.setDate(commandeArticle.getCommande().getDate());
        commandeArticleDto.setDate_paiement(commandeArticle.getCommande().getDatePaiement());
        commandeArticleDto.setId_user(commandeArticle.getCommande().getUtilisateur().getId());
        commandeArticleDto.setId_paiement(commandeArticle.getCommande().getPaiement().getId());
        commandeArticleDto.setId_fournisseur(commandeArticle.getCommande().getFournisseur().getId());
        commandeArticleDto.setNbr_paiement(commandeArticle.getCommande().getNbrpaiement());
        commandeArticleDto.setPaiement(commandeArticle.getCommande().getPaiement().getType());
        commandeArticleDto.setDemande(commandeArticle.getCommande().getDemande().getId());
        commandeArticleDto.setNom(commandeArticle.getCommande().getUtilisateur().getNom_utilisateur());
        commandeArticleDto.setFournisseur(commandeArticle.getCommande().getFournisseur().getNom());
        commandeArticleDto.setId_article(commandeArticle.getArticle().getId());
        commandeArticleDto.setDescription(commandeArticle.getArticle().getDescription());
        commandeArticleDto.setQuantite(commandeArticle.getArticle().getQuantite());
        commandeArticleDto.setQuantite_demande(commandeArticle.getArticle().getQuantite_demande());
        commandeArticleDto.setQuantite_commande(commandeArticle.getQuantite_commande());
        commandeArticleDto.setPrix_unitaire(commandeArticle.getArticle().getPrix_unitaire());
        commandeArticleDto.setDemandeId(commandeArticle.getArticle().getDemande().getId());

        return commandeArticleDto;
    }
}
