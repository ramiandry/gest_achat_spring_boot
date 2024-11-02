package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FournisseurDto;
import com.gest_achats.gest_achat.model.Fournisseur;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FournisseurService {
    public List<FournisseurDto> get();
    public ResponseEntity<FournisseurDto> getById(Long id);
    public ResponseEntity<FournisseurDto> create(Fournisseur fournisseur);
    public ResponseEntity<FournisseurDto> edit(Fournisseur fournisseur, Long id);
    public String delete(Long id);
    public FournisseurDto convertToEntite(Fournisseur fournisseur);
}
