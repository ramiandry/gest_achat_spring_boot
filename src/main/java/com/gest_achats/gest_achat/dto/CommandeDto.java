package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CommandeDto {
    private Long id;
    private Date date;
    private Date date_paiement;
    private Long id_user;
    private Long id_paiement;
    private Long id_fournisseur;
    private String email_fournisseur;
    private int nbr_paiement;
    private String paiement;
    private Long demande;
    private String nom;
    private String fournisseur;
}
