package com.gest_achats.gest_achat.controller;


import com.gest_achats.gest_achat.dto.CommandeDto;
import com.gest_achats.gest_achat.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("getAll")
    public List<CommandeDto> getAdmin() {
        return this.commandeService.get();
    }

    @PostMapping("create")
    public ResponseEntity<CommandeDto> create(@RequestBody final CommandeDto commandeDto) {
        return this.commandeService.create(commandeDto);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.commandeService.delete(id);
    }
}
