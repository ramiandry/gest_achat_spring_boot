package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facture_article")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FactureArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facturation facturation;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private Double tva;

}
