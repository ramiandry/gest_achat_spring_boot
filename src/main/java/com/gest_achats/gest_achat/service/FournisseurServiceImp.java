package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FournisseurDto;
import com.gest_achats.gest_achat.model.Fournisseur;
import com.gest_achats.gest_achat.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseurServiceImp implements FournisseurService{

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public List<FournisseurDto> get() {
        return this.fournisseurRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<FournisseurDto> getById(Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.fournisseurRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<FournisseurDto> create(Fournisseur fournisseur) {
        this.fournisseurRepository.save(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.fournisseurRepository.findById(fournisseur.getId()).map(this::convertToEntite).get());

    }
    @Override
    public ResponseEntity<FournisseurDto> edit(Fournisseur fournisseur, Long id) {
        Fournisseur fournisseur1=this.fournisseurRepository.findById(id).get();
        System.out.println(fournisseur.getAdresse());
        fournisseur1.setAdresse(fournisseur.getAdresse());
        fournisseur1.setTel(fournisseur.getTel());
        fournisseur1.setEmail(fournisseur.getEmail());
        fournisseur1.setNom(fournisseur.getNom());
        this.fournisseurRepository.save(fournisseur1);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.fournisseurRepository.findById(fournisseur1.getId()).map(this::convertToEntite).get());

    }

    @Override
    public String delete(Long id) {
        this.fournisseurRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public FournisseurDto convertToEntite(Fournisseur fournisseur) {
        FournisseurDto fournisseurDto=new FournisseurDto();
        fournisseurDto.setId(fournisseur.getId());
        fournisseurDto.setNom(fournisseur.getNom());
        fournisseurDto.setEmail(fournisseur.getEmail());
        fournisseurDto.setAdresse(fournisseur.getAdresse());
        fournisseurDto.setTel(fournisseur.getTel());
        return fournisseurDto;
    }
}
