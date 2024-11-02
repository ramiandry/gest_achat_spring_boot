package com.gest_achats.gest_achat.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "paiement")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "id")
    private List<Commande> commandes;
}
