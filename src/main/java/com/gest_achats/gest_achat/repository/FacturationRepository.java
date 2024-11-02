package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Facturation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturationRepository extends JpaRepository<Facturation, Long> {
}
