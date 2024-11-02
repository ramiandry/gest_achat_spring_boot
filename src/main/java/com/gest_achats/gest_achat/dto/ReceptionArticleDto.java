package com.gest_achats.gest_achat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionArticleDto {
    private Long id_article;
    private String description;
    private int quantite;
    private int quantite_demande;
    private Double prix_unitaire;
    private Long demandeId;
    private Date date_demande;
    private int quantite_recu;
    private int quantite_commande;
    private Long id_reception;
    private Date date_reception;
    private String receptionniste;
    private String emplacement;
    private Long id_livraison;
    private Date date_livraison;
    private boolean status;
    private Long id_user;
    private String nom;
    private String fournisseur;
}
