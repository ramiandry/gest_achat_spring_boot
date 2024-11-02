package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "commande_article")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private int quantite_commande;
}
