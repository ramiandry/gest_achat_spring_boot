package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ArticleDto {
    private Long id;
    private String description;
    private int quantite;
    private int quantite_demande;
    private Double prix_unitaire;
    private Long demandeId;
    private Date date;
    private int quantite_commande;
}
