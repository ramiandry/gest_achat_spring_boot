package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.PaiementDto;
import com.gest_achats.gest_achat.model.Paiement;
import com.gest_achats.gest_achat.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementServiceImp implements PaiementService{

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public List<PaiementDto> get() {
        return this.paiementRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Paiement> create(Paiement paiement) {
        this.paiementRepository.save(paiement);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(paiement);
    }

    @Override
    public ResponseEntity<Paiement> edit(Paiement paiement, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.paiementRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public PaiementDto convertToEntite(Paiement paiement) {
        PaiementDto paiementDto=new PaiementDto();
        paiementDto.setId(paiement.getId());
        paiementDto.setType(paiement.getType());
        return paiementDto;
    }
}
