package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.DemandeDto;
import com.gest_achats.gest_achat.model.Demande;
import com.gest_achats.gest_achat.repository.DemandeRepository;
import com.gest_achats.gest_achat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeServiceImp implements DemandeService{

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<DemandeDto> get() {
        return this.demandeRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<DemandeDto> create(Demande demande, Long id) {
        demande.setUtilisateur(this.utilisateurRepository.findById(id).get());
        demande.setValideBudget(null);
        demande.setValideQuantite(null);
        this.demandeRepository.save(demande);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.demandeRepository.findById(demande.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<DemandeDto> getById(Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.demandeRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<DemandeDto> edit(Demande demande, Long id) {
        Demande demande1=this.demandeRepository.findById(id).get();
        demande1.setDate(demande.getDate());
        demande1.setDescription(demande.getDescription());
        this.demandeRepository.save(demande1);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.demandeRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<DemandeDto> validBudget(Demande demande1,Long id) {
        Demande demande=this.demandeRepository.findById(id).get();
        demande.setValideBudget(demande1.getValideBudget());
        this.demandeRepository.save(demande);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.demandeRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<DemandeDto> validQuantite(Demande demande1,Long id) {
        Demande demande=this.demandeRepository.findById(id).get();
        demande.setValideQuantite(demande1.getValideQuantite());
        this.demandeRepository.save(demande);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.demandeRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public String delete(Long id) {
        this.demandeRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public DemandeDto convertToEntite(Demande demande) {
        DemandeDto demandeDto=new DemandeDto();
        demandeDto.setId(demande.getId());
        demandeDto.setDate(demande.getDate());
        demandeDto.setBudget(demande.getValideBudget());
        demandeDto.setQuantite(demande.getValideQuantite());
        demandeDto.setUsername(demande.getUtilisateur().getNom_utilisateur());
        demandeDto.setDescription(demande.getDescription());
        return demandeDto;
    }
}
