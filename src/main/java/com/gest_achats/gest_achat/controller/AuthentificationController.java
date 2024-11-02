package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.UtilisateurDto;
import com.gest_achats.gest_achat.model.Utilisateur;
import com.gest_achats.gest_achat.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthentificationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UtilisateurDto utilisateur
            ){
        return ResponseEntity.ok(service.register(utilisateur));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody Utilisateur utilisateur
    ){
        return ResponseEntity.ok(service.login(utilisateur));
    }
}
