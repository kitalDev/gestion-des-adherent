package com.example.gestionAdherents.service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UtilisateurDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private RoleUtilisateurDTO role;
}
