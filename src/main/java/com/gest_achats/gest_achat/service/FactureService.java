package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FactureDto;
import com.gest_achats.gest_achat.model.Facturation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FactureService {
    public List<FactureDto> get();
    public ResponseEntity<FactureDto> create(Facturation facturation);
    public ResponseEntity<Facturation> edit(Facturation facturation, Long id);
    public String delete(Long id);
    public FactureDto convertToEntite(Facturation facturation);
}
