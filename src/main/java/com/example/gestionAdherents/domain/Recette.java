package com.example.gestionAdherents.domain;

import com.example.gestionAdherents.utils.SizeMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "recettes")
public class Recette extends AbstractEntity{
    @NotBlank(message = "Veuillez renseigner le montant")
    @Min(SizeMapper.MINCO)
    @Max(SizeMapper.MAXCO)
    private double montant;

    @ManyToOne
    @JoinColumn(name = "adherent")
    private Adherent adherent;

    @ManyToOne
    @JoinColumn(name = "versement")
    private Versement versement;

    @ManyToOne
    @JoinColumn(name = "type")
    private TypeRecette typeRecette;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

}
