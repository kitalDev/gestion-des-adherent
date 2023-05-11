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
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "adherents")
public class Adherent extends AbstractEntity{

    @NotBlank(message = "Veuillez saisir le prenom")
    @Size(
            min = SizeMapper.SizePrenom.MIN,
            max = SizeMapper.SizePrenom.MAX,
            message = "le prenom doit etre entre 2 et 20 caracteres"
    )
    @Column(name = "prenom", nullable = false, length = SizeMapper.LENGTH)
    private String prenom;

    @NotBlank(message = "Veuillez saisir le nom")
    @Size(
            min = SizeMapper.SizeNom.MIN,
            max = SizeMapper.SizeNom.MAX,
            message = "le nom doit etre entre 2 et 10 caracteres"
    )
    @Column(name = "nom", nullable = false, length = SizeMapper.LENGTH)
    private String nom;

    private LocalDate dateNaissance;
    private String adresse;

    @NotBlank(message = "Veuillez saisir le nom")
    @Min(
            value = SizeMapper.MIN,
            message = "le CNI doit avoir au moins 14 caractere"
    )

    @Column(name = "cni", nullable = false, length = SizeMapper.LENGTH)
    private String cni;
    private String serve;

    @OneToMany(mappedBy = "adherent")
    Set<Cotisations> cotisations = new HashSet<>() ;

    @OneToMany(mappedBy = "adherent")
    Set<Recette> recettes = new HashSet<>() ;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
}
