package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.ReceptionDto;
import com.gest_achats.gest_achat.model.Reception;
import com.gest_achats.gest_achat.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reception")
public class ReceptionController {
    @Autowired
    private ReceptionService receptionService;

    @GetMapping("getAll")
    public List<ReceptionDto> get() {
        return this.receptionService.get();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<ReceptionDto> getById(@PathVariable("id") Long id) {
        return this.receptionService.getById(id);
    }

    @PostMapping("create")
    public ResponseEntity<ReceptionDto> create(@RequestBody final Reception reception) {
        return this.receptionService.create(reception);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.receptionService.delete(id);
    }
}
