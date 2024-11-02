package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReceptionDto {
    private Long id;
    private Date date;
    private String receptionist;
    private String emplacement;
    private Long id_livraison;
    private Date date_livraison;
    private boolean status;
    private Long id_user;
    private String nom;
    private Long id_commande;
    private Long id_demande;
    private Long id_receptionniste;
    private String receptionniste;
    private String fournisseur;
}
