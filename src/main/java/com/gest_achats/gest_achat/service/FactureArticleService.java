package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FactureArticleDto;
import com.gest_achats.gest_achat.model.Facturation;
import com.gest_achats.gest_achat.model.FactureArticle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FactureArticleService {
    public List<FactureArticleDto> get();
    public ResponseEntity<FactureArticleDto> create(FactureArticle factureArticle);
    public ResponseEntity<FactureArticleDto> edit(FactureArticleDto factureArticleDto, Long id);
    public String delete(Long id);
    public FactureArticleDto convertToEntite(FactureArticle factureArticle);
}
