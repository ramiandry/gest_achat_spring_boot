package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "livraison")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @OneToMany(mappedBy = "id")
    private List<Reception> receptions ;

    public boolean getStatus() {
        return this.status;
    }
}
