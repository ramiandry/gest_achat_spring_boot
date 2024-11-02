package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.UtilisateurDto;
import com.gest_achats.gest_achat.model.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UtilisateurService {
    public List<UtilisateurDto> get();
    public ResponseEntity<UtilisateurDto> create(MultipartFile avatar, String nom_utilisateur, String email, String tel, String mdp, long role, long departementId);
    public ResponseEntity<UtilisateurDto> edit(Long id, MultipartFile avatar, String nom_utilisateur, String email, String tel, String mdp, long role, long departementId);
    public ResponseEntity<UtilisateurDto> editStatus(Long id);
    public String delete(Long id);

    public byte[] show(Long id) throws IOException;

    public UtilisateurDto getOne(Long id);

    public UtilisateurDto convertToEntite(Utilisateur utilisateur);
}
