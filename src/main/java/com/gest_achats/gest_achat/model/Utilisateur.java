package com.gest_achats.gest_achat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "utilisateur")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String avatar;

    @Column
    private String nom_utilisateur;

    @Column
    private String email;

    @Column
    private String tel;

    @Column
    private String mot_de_passe;

    @Column
    private boolean valide;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "id")
    private List<Demande> demandes;

    @OneToMany(mappedBy = "id")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "id")
    private List<Reception> receptions;

    public boolean getValide() {
        return this.valide;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.mot_de_passe;
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
