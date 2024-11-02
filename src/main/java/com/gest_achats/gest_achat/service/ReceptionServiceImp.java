package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ReceptionDto;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.repository.LivraisonRepository;
import com.gest_achats.gest_achat.repository.ReceptionRepository;
import com.gest_achats.gest_achat.repository.ReceptionnisteRepository;
import com.gest_achats.gest_achat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptionServiceImp implements  ReceptionService{

    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    public ReceptionnisteRepository receptionnisteRepository;

    @Autowired
    private LivraisonRepository livraisonRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public List<ReceptionDto> get() {
        return this.receptionRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ReceptionDto> getById(Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.receptionRepository.findById(id).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<ReceptionDto> create(Reception reception) {
        reception.setLivraison(this.livraisonRepository.findById(reception.getLivraison().getId()).get());
        reception.setUtilisateur(this.utilisateurRepository.findById(reception.getUtilisateur().getId()).get());
        reception.setReceptionniste(this.receptionnisteRepository.findById(reception.getReceptionniste().getId()).get());
        this.receptionRepository.save(reception);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.receptionRepository.findById(reception.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<Reception> edit(Reception reception, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.receptionRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public ReceptionDto convertToEntite(Reception reception) {
        ReceptionDto receptionDto=new ReceptionDto();
        receptionDto.setId(reception.getId());
        receptionDto.setDate(reception.getDate());
        receptionDto.setReceptionist(reception.getReceptionist());
        receptionDto.setEmplacement(reception.getEmplacement());
        receptionDto.setId_user(reception.getUtilisateur().getId());
        receptionDto.setNom(reception.getUtilisateur().getNom_utilisateur());
        receptionDto.setId_livraison(reception.getLivraison().getId());
        receptionDto.setDate_livraison(reception.getLivraison().getDate());
        receptionDto.setStatus(reception.getLivraison().getStatus());
        receptionDto.setFournisseur(reception.getLivraison().getCommande().getFournisseur().getNom());
        receptionDto.setId_commande(reception.getLivraison().getCommande().getId());
        receptionDto.setId_demande(reception.getLivraison().getCommande().getDemande().getId());
        receptionDto.setId_receptionniste(reception.getReceptionniste().getId());
        receptionDto.setReceptionniste(reception.getReceptionniste().getNom());
        return receptionDto;
    }
}
