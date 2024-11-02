package com.gest_achats.gest_achat.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DemandeDto {
    private Long id;
    private Date date;
    private Boolean budget;
    private Boolean quantite;
    private String username;
    private String Description;

}
