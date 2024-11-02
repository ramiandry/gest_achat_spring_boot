package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.LivraisonDto;
import com.gest_achats.gest_achat.model.Livraison;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LivraisonService {
    public List<LivraisonDto> get();
    public ResponseEntity<LivraisonDto> create(Livraison livraison);
    public ResponseEntity<Livraison> edit(Livraison livraison, Long id);
    public String delete(Long id);
    public LivraisonDto convertToEntite(Livraison livraison);
}
