package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Commande")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "date_paiement")
    private Date datePaiement;

    @Column(name = "nbr_paiement")
    private int nbrpaiement;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @OneToMany(mappedBy = "id")
    private  List<Facturation> facturations;

    @OneToMany(mappedBy = "id")
    private  List<Livraison> livraisons;

    @OneToMany(mappedBy = "id")
    private  List<CommandeArticle> commandeArticles;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
}
