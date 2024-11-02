package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ReceptionDto;
import com.gest_achats.gest_achat.model.Reception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReceptionService {
    public List<ReceptionDto> get();
    public ResponseEntity<ReceptionDto> getById(Long id);
    public ResponseEntity<ReceptionDto> create(Reception reception);
    public ResponseEntity<Reception> edit(Reception reception, Long id);
    public String delete(Long id);
    public ReceptionDto convertToEntite(Reception reception);
}
