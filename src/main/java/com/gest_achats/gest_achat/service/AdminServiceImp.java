package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.AdminDto;
import com.gest_achats.gest_achat.model.Admin;
import com.gest_achats.gest_achat.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImp implements  AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<AdminDto> get() {
        return this.adminRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<AdminDto> create(Admin admin) {
        this.adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.adminRepository.findById(admin.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<Admin> edit(Admin admin, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.adminRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public AdminDto convertToEntite(Admin admin) {
        AdminDto adminDto=new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setType(admin.getType());
        return adminDto;
    }
}
