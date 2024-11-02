package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.DepartementDto;
import com.gest_achats.gest_achat.model.Departement;
import com.gest_achats.gest_achat.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartementServiceImp implements DepartementService{

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<DepartementDto> get() {
        return this.departementRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Departement> create(Departement departement) {
        this.departementRepository.save(departement);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(departement);
    }

    @Override
    public ResponseEntity<Departement> edit(Departement departement, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {

        return "delete succesfully !!";
    }

    @Override
    public DepartementDto convertToEntite(Departement departement) {
        DepartementDto departementDto=new DepartementDto();
        departementDto.setId(departement.getId());
        departementDto.setDepartement(departement.getDepartement());
        return departementDto;
    }
}
