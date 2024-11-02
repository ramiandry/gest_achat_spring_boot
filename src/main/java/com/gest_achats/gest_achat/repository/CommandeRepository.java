package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
