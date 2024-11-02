package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Article;
import com.gest_achats.gest_achat.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long > {
    @Query("SELECT a FROM Article a WHERE a.demande=?1")
    List<Article> findByDemande(Demande demande);

    

}
