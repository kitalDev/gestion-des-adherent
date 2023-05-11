package com.example.gestionAdherents.domain;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "roleUtilisateurs")
@Tag(name = "roleutilisateurs")
public class RoleUtilisateur extends AbstractEntity{
    private String nom;
}
