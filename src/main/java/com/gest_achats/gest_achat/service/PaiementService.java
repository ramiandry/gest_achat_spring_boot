package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.model.Paiement;
import com.gest_achats.gest_achat.dto.PaiementDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaiementService {
    public List<PaiementDto> get();
    public ResponseEntity<Paiement> create(Paiement paiement);
    public ResponseEntity<Paiement> edit(Paiement paiement, Long id);
    public String delete(Long id);
    public PaiementDto convertToEntite(Paiement paiement);
}
