package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Commande;
import com.gest_achats.gest_achat.model.CommandeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle, Long > {
    List<CommandeArticle> findByCommande(Commande commande);
}
