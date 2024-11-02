package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "article")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "prix_unitaire")
    private Double prix_unitaire;

    @Column
    private int quantite_demande;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @Column
    private int quantite_commande;

    @OneToMany(mappedBy = "id")
    private List<ReceptionArticle> receptionArticles;

    @OneToMany(mappedBy = "id")
    private List<CommandeArticle> commandeArticles;

    @OneToMany(mappedBy = "id")
    private List<FactureArticle> factureArticles;

}





