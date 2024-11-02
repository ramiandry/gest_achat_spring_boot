package com.gest_achats.gest_achat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionnisteDto {

    private Long id;
    private String nom;
    private String email;
    private String tel;
    private String signature;
}
