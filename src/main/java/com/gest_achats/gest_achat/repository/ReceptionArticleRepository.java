package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.dto.ReceptionArticleDto;
import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.model.ReceptionArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReceptionArticleRepository extends JpaRepository<ReceptionArticle,Long> {
    List<ReceptionArticle> findByReception(Reception reception);

}
