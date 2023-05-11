package com.example.gestionAdherents.domain;

import com.example.gestionAdherents.domain.enums.TypeCotisation;
import com.example.gestionAdherents.utils.SizeMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "cotisations")
public class Cotisations extends AbstractEntity{

    @NotBlank(message = "Veuillez renseigner le montant")
    @Min(
            value = SizeMapper.MINCO,
            message = "le montant doit etre au minimum 500"
    )
    @Max(
            value=SizeMapper.MAXCO,
            message = "le montant doit etre au maximum 5000000"
    )
    private double montant;
    @NotBlank(message = "Veuillez saisir le type de cotisation")
    private TypeCotisation typeCotisation;
    private Date periode;

    @ManyToOne
    @JoinColumn(name = "adherent")
    private Adherent adherent;

    @ManyToOne
    @JoinColumn(name = "versement")
    private Versement versement;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
