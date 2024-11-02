package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FactureArticleDto {
    private Long id;
    private Date date_facture;
    private Long id_commande;
    private int quantite_commande;
    private Long id_article;
    private String description;
    private int quantite;
    private int quantite_demande;
    private Double prix_unitaire;
    private Long demandeId;
    private Double tva;
    private Long id_reception;
    private int quantite_recu;
}
