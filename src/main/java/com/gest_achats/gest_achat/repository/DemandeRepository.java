package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
}