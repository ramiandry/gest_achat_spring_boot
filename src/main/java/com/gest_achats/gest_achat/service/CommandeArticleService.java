package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.CommandeArticleDto;
import com.gest_achats.gest_achat.dto.ReceptionArticleDto;
import com.gest_achats.gest_achat.model.CommandeArticle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeArticleService {
    public List<CommandeArticleDto> get();
    public List<CommandeArticleDto> getByCommande(Long id);
    public ResponseEntity<CommandeArticleDto> create(CommandeArticle commandeAritcle);
    public ResponseEntity<CommandeArticle> edit(CommandeArticle commandeAritcle, Long id);
    public String delete(Long id);

    public CommandeArticleDto convertToEntite(CommandeArticle commandeArticle);
}
