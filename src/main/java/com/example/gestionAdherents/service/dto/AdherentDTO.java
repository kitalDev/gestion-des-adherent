package com.example.gestionAdherents.service.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdherentDTO {
    private String id;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String adresse;
    private String cni;
    private String serve;
    private String utilisateurId;

    public AdherentDTO(String id){
        this.id=id;
    }
}
