package com.gest_achats.gest_achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "receptionniste")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receptionniste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;

    @Column
    private String email;

    @Column
    private String tel;

     @Column
    private String signature;

    @OneToMany(mappedBy = "id")
    private List<Reception> receptions;

}
