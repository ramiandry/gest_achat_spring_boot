package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long > {
}
