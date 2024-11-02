package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.UtilisateurDto;
import com.gest_achats.gest_achat.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("getAll")
    public List<UtilisateurDto> get() {
        return this.utilisateurService.get();
    }

    @GetMapping("getById/{id}")
    public UtilisateurDto getById(@PathVariable("id") Long id){
        return this.utilisateurService.getOne(id);
    }

    @PostMapping("editStatus/{id}")
    public ResponseEntity<UtilisateurDto> editStatus(@PathVariable("id") Long id){
        return this.utilisateurService.editStatus(id);
    }

    @PostMapping("create")
    public ResponseEntity<UtilisateurDto> create(@RequestParam("avatar") MultipartFile avatar,
                                                 @RequestParam("username") String nom_utilisateur,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("mot_de_passe") String mdp,
                                                 @RequestParam("tel") String tel,
                                                 @RequestParam("role") long role,
                                                 @RequestParam("departement") long departement) {

        return this.utilisateurService.create(avatar, nom_utilisateur, email,tel,mdp, role,departement);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<UtilisateurDto> edit(@RequestParam(value = "avatar", defaultValue = "") MultipartFile avatar,
                                                 @PathVariable("id") Long id,
                                                 @RequestParam("username") String nom_utilisateur,
                                                 @RequestParam("email") String email,
                                                 @RequestParam(value = "mot_de_passe", defaultValue = "") String mdp,
                                                 @RequestParam("tel") String tel,
                                                 @RequestParam(value = "role",defaultValue ="0") long role,
                                                 @RequestParam(value = "departement", defaultValue = "0") long departement) {

        return this.utilisateurService.edit(id, avatar, nom_utilisateur, email,tel,mdp, role,departement);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.utilisateurService.delete(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Long id) throws IOException {
        byte[] images=this.utilisateurService.show(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_PNG)
                .body(images);
    }
}
