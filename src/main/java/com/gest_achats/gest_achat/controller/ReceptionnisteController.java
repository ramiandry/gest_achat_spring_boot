package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.ReceptionnisteDto;
import com.gest_achats.gest_achat.model.Receptionniste;
import com.gest_achats.gest_achat.service.ReceptionnisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/receptionniste")
public class ReceptionnisteController {

    @Autowired
    private ReceptionnisteService receptionnisteService;

    @GetMapping("getAll")
    public List<ReceptionnisteDto> get() {
        return this.receptionnisteService.getAll();
    }

    @PostMapping("create")
    public ResponseEntity<ReceptionnisteDto> create(@RequestParam("email") String email,
                                                    @RequestParam("nom") String nom,
                                                    @RequestParam("tel") String tel,
                                                    @RequestParam("file") MultipartFile signature) {
        Receptionniste receptionniste=new Receptionniste(null, nom, email, tel,null, null);
        return this.receptionnisteService.create(receptionniste, signature);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.receptionnisteService.delete(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Long id) throws IOException {
        byte[] images=this.receptionnisteService.show(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_PNG)
                .body(images);
    }
}
