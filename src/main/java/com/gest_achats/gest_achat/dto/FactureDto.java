package com.gest_achats.gest_achat.dto;

import lombok.Data;
import java.util.Date;

@Data
public class FactureDto {
    private Long id;
    private Date date;
    private Long id_commande;
    private Date date_commande;
    private Long id_user;
    private String nom;
    private Long id_reception;
    private String fournisseur;
    private String saisie;
    private String reçeptionist;
    private String receptionniste;
}
