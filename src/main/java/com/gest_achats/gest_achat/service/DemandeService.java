package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.DemandeDto;
import com.gest_achats.gest_achat.model.Demande;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeService {

    public List<DemandeDto> get();
    public ResponseEntity<DemandeDto> create(Demande demande, Long id);
    public ResponseEntity<DemandeDto> getById(Long id);
    public ResponseEntity<DemandeDto> edit(Demande demande, Long id);
    public ResponseEntity<DemandeDto> validBudget(Demande demande,Long id);
    public ResponseEntity<DemandeDto> validQuantite(Demande demande,Long id);
    public String delete(Long id);
    public DemandeDto convertToEntite(Demande demande);
}
