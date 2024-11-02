package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Admin;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AdminRepository extends JpaRepository<Admin, Long > {
}
