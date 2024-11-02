package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.CommandeDto;
import com.gest_achats.gest_achat.model.Commande;
import com.gest_achats.gest_achat.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImp implements CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Override
    public List<CommandeDto> get() {
        return this.commandeRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<CommandeDto> create(CommandeDto commandeDto) {
        Commande commande=new Commande();
        commande.setFournisseur(this.fournisseurRepository.findById(commandeDto.getId_fournisseur()).get());
        commande.setDemande(this.demandeRepository.findById(commandeDto.getDemande()).get());
        commande.setUtilisateur(this.utilisateurRepository.findById(commandeDto.getId_user()).get());
        commande.setPaiement(this.paiementRepository.findById(commandeDto.getId_paiement()).get());
        commande.setDate(commandeDto.getDate());
        commande.setNbrpaiement(commandeDto.getNbr_paiement());
        commande.setDatePaiement(commandeDto.getDate_paiement());
        this.commandeRepository.save(commande);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.commandeRepository.findById(commande.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<Commande> edit(Commande commande, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.commandeRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public CommandeDto convertToEntite(Commande commande) {
        CommandeDto commandeDto =new CommandeDto();
        commandeDto.setId(commande.getId());
        commandeDto.setDate(commande.getDate());
        commandeDto.setDemande(commande.getDemande().getId());
        commandeDto.setNom(commande.getUtilisateur().getNom_utilisateur());
        commandeDto.setFournisseur(commande.getFournisseur().getNom());
        commandeDto.setDate_paiement(commande.getDatePaiement());
        commandeDto.setNbr_paiement(commande.getNbrpaiement());
        commandeDto.setPaiement(commande.getPaiement().getType());
        commandeDto.setId_user(commande.getUtilisateur().getId());
        commandeDto.setId_fournisseur(commande.getFournisseur().getId());
        commandeDto.setId_paiement(commande.getPaiement().getId());
        commandeDto.setEmail_fournisseur(commande.getFournisseur().getEmail());
        return commandeDto;
    }
}
