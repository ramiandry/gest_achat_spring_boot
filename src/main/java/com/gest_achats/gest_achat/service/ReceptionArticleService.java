package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ReceptionArticleDto;
import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.model.ReceptionArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReceptionArticleService {
    public List<ReceptionArticleDto> get();
    public List<ReceptionArticleDto> getByReception(Long reception);
    //public ResponseEntity<ReceptionArticleDto> getByReceptionArticle(Reception reception, Article article);
    ResponseEntity<ReceptionArticleDto> create(ReceptionArticle receptionArticle);
    public ResponseEntity<ReceptionArticleDto> edit(ReceptionArticle receptionArticle, Long id);
    public String delete(Long id);
    public ReceptionArticleDto convertToEntite(ReceptionArticle receptionArticle);
}
