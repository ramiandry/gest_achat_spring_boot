package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long > {
}
