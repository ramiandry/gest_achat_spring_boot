package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "departement")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String departement;

    @OneToMany(mappedBy = "id")
    private List<Utilisateur> utilisateurs;
}
