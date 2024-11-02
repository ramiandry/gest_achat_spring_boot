package com.gest_achats.gest_achat.model;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Demande")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    String description;
    @Column(name = "date")
    private Date date;
    
    @Column(name = "valide_quantite")
    private Boolean valideQuantite;

    @Column(name = "valide_budget")
    private Boolean valideBudget;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "id")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "id")
    private List<Demande> demandes;


}
