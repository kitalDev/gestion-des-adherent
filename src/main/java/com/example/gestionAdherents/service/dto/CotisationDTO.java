package com.example.gestionAdherents.service.dto;


import com.example.gestionAdherents.domain.Adherent;
import com.example.gestionAdherents.domain.Versement;
import com.example.gestionAdherents.domain.enums.TypeCotisation;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CotisationDTO {
    private String id;
    private double montant;
    private TypeCotisation typeCotisation;
    private Date periode;
    private AdherentDTO adherent;
    private VersementDTO versement;
    private String utilisateurId;
}
