package com.example.gestionAdherents.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "type_recettes")
public class TypeRecette extends AbstractEntity {
    @NotBlank(message = "Veuillez renseigner le type")
    private String type;
}
