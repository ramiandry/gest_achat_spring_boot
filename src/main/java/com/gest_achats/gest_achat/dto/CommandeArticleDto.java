package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeArticleDto {
    private Long id;
    private Date date;
    private Date date_paiement;
    private Long id_user;
    private Long id_paiement;
    private Long id_fournisseur;
    private int nbr_paiement;
    private String paiement;
    private Long demande;
    private String nom;
    private String fournisseur;
    private Long id_article;
    private String description;
    private int quantite;
    private int quantite_demande;
    private Double prix_unitaire;
    private Long demandeId;
    private int quantite_commande;
}
