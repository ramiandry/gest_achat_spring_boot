package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.LivraisonDto;
import com.gest_achats.gest_achat.model.Livraison;
import com.gest_achats.gest_achat.repository.CommandeRepository;
import com.gest_achats.gest_achat.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivraisonServiceImp implements LivraisonService{

    @Autowired
    private LivraisonRepository livraisonRepository;

    @Autowired
    private CommandeRepository commandeRepository;
    @Override
    public List<LivraisonDto> get() {
        return this.livraisonRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<LivraisonDto> create(Livraison livraison) {
        livraison.setCommande(this.commandeRepository.findById(livraison.getCommande().getId()).get());
        this.livraisonRepository.save(livraison);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.livraisonRepository.findById(livraison.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<Livraison> edit(Livraison livraison, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.livraisonRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public LivraisonDto convertToEntite(Livraison livraison) {
        LivraisonDto livraisonDto=new LivraisonDto();
        livraisonDto.setId(livraison.getId());
        livraisonDto.setDate(livraison.getDate());
        livraisonDto.setStatus(livraison.getStatus());
        livraisonDto.setId_commande(livraison.getCommande().getId());
        livraisonDto.setDate_commande(livraison.getCommande().getDate());
        return livraisonDto;
    }
}
