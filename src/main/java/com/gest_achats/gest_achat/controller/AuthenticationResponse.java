package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.UtilisateurDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Long id;
}
