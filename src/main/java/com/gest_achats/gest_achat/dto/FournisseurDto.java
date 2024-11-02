package com.gest_achats.gest_achat.dto;

import lombok.Data;

@Data
public class FournisseurDto {
    private long id;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
}
