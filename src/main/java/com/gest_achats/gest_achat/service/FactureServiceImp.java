package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.FactureDto;
import com.gest_achats.gest_achat.model.Facturation;
import com.gest_achats.gest_achat.repository.CommandeRepository;
import com.gest_achats.gest_achat.repository.FacturationRepository;
import com.gest_achats.gest_achat.repository.ReceptionRepository;
import com.gest_achats.gest_achat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureServiceImp implements FactureService {

    @Autowired
    private FacturationRepository facturationRepository;

    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<FactureDto> get() {
        return this.facturationRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<FactureDto> create(Facturation facturation) {
        facturation.setReception(this.receptionRepository.findById(facturation.getReception().getId()).get());
        facturation.setUtilisateur(this.utilisateurRepository.findById(facturation.getUtilisateur().getId()).get());
        facturation.setCommande(this.commandeRepository.findById(facturation.getCommande().getId()).get());
        this.facturationRepository.save(facturation);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.facturationRepository.findById(facturation.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<Facturation> edit(Facturation facturation, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.facturationRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public FactureDto convertToEntite(Facturation facturation) {
        FactureDto factureDto=new FactureDto();
        factureDto.setId(facturation.getId());
        factureDto.setDate(facturation.getDate());
        factureDto.setId_commande(facturation.getCommande().getId());
        factureDto.setId_user(facturation.getUtilisateur().getId());
        factureDto.setNom(facturation.getUtilisateur().getNom_utilisateur());
        factureDto.setId_reception(facturation.getReception().getId());
        factureDto.setFournisseur(facturation.getCommande().getFournisseur().getNom());
        factureDto.setReçeptionist(facturation.getReception().getReceptionniste().getNom());
        return factureDto;
    }
}
