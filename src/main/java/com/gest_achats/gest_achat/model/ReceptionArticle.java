package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reception_article")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reception_id")
    private Reception reception;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private int recu;
}
