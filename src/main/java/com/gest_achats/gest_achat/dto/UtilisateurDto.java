package com.gest_achats.gest_achat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {
    private Long userId;
    private String userAvatar;
    private String userUsername;
    private String userTel;
    private String userEmail;
    private String userMdp;
    private Long id_admin;
    private Long id_departement;
    private boolean userValide;
    private Long id_role;
    private String type;
    private String departement;
}
