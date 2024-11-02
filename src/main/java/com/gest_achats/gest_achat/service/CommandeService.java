package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.CommandeDto;
import com.gest_achats.gest_achat.model.Commande;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeService {
    public List<CommandeDto> get();
    public ResponseEntity<CommandeDto> create(CommandeDto commandeDto);
    public ResponseEntity<Commande> edit(Commande commande, Long id);
    public String delete(Long id);
    public CommandeDto convertToEntite(Commande commande);
}
