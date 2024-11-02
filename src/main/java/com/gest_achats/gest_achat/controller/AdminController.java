package com.gest_achats.gest_achat.controller;

import com.gest_achats.gest_achat.dto.AdminDto;
import com.gest_achats.gest_achat.model.Admin;
import com.gest_achats.gest_achat.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("getAll")
    public List<AdminDto> getAdmin() {
        return this.adminService.get();
    }

    @PostMapping("create")
    public ResponseEntity<AdminDto> create(@RequestBody final Admin admin) {
        return this.adminService.create(admin);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return this.adminService.delete(id);
    }
    }
