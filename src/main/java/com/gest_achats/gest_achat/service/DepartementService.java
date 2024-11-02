package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.DepartementDto;
import com.gest_achats.gest_achat.model.Departement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartementService {
    public List<DepartementDto> get();
    public ResponseEntity<Departement> create(Departement departement);
    public ResponseEntity<Departement> edit(Departement departement, Long id);
    public String delete(Long id);
    public DepartementDto convertToEntite(Departement departement);
}
