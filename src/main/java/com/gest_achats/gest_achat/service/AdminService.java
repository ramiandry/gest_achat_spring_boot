package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.AdminDto;
import com.gest_achats.gest_achat.model.Admin;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    public List<AdminDto> get();
    public ResponseEntity<AdminDto> create(Admin admin);
    public ResponseEntity<Admin> edit(Admin admin, Long id);
    public String delete(Long id);
    AdminDto convertToEntite(Admin admin);
}
