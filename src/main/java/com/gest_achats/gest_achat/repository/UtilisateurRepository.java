package com.gest_achats.gest_achat.repository;

import com.gest_achats.gest_achat.model.Utilisateur;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long > {
    Optional<Utilisateur> findByEmail(String email);
}
