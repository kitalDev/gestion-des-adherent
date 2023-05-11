package com.example.gestionAdherents.service.dto;


import com.example.gestionAdherents.domain.Adherent;
import com.example.gestionAdherents.domain.TypeRecette;
import com.example.gestionAdherents.domain.Versement;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecetteDTO {
    private String id;
    private double montant;
    private AdherentDTO adherent;
    private VersementDTO versement;
    private TypeRecetteDTO typeRecette;
    private String utilisateurId;
}
