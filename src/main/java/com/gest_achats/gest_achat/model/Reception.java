package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "reception")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Date date;
    @Column
    private String receptionist;
    @Column
    private String emplacement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;

    @ManyToOne
    @JoinColumn(name = "receptionniste_id")
    private Receptionniste receptionniste;

    @OneToMany(mappedBy = "id")
    private List<ReceptionArticle> receptionArticles;
}
