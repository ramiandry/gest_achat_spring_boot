package com.gest_achats.gest_achat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class LivraisonDto {
    private Long id;;
    private Date date;
    private boolean status;
    private Long id_commande;
    private Date date_commande;
}
