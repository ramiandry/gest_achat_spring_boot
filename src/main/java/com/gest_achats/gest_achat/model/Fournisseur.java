package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Fournisseur")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name ="tel")
    private String tel;
    @Column(name ="email")
    private String email;
    @OneToMany(mappedBy = "id")
    private List<Commande> commandes;

}
