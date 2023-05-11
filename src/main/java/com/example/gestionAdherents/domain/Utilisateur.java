package com.example.gestionAdherents.domain;

import com.example.gestionAdherents.utils.SizeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "utilisateurs")
@Tag(name = "utilisateur")
public class Utilisateur extends AbstractEntity implements UserDetails {
    @NotBlank
    @Size(
            min = SizeMapper.SizeNom.MIN,
            max = SizeMapper.SizeNom.MAX,
            message = "le prenom doit contenir entre 3 et 20 caractéres"
    )
    @Column(name = "firstname", nullable = false, length = SizeMapper.LENGTH)
    private String nom;
    @NotBlank(message = "le nom ne doit pas etre vide")
    @Size(
            min = SizeMapper.SizePrenom.MIN,
            max = SizeMapper.SizePrenom.MAX,
            message = "le nom doit contenir entre 3 et 10 caracteres"
    )
    @Column(name = "lastname", nullable = false, length = SizeMapper.LENGTH)
    private String prenom;

    @NotBlank(message = "l'email ne doit pas etre vide")
    @Email(message = "verifier bien le mail saisis")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "le mot de passe de doit pas etre vide")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @OneToOne
    private RoleUtilisateur role;

    @OneToMany(mappedBy = "utilisateur")
    private List<Adherent> adherents;
    @OneToMany(mappedBy = "utilisateur")
    private List<Cotisations> cotisations;
    @OneToMany(mappedBy = "utilisateur")
    private List<Recette> recettes;
    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getNom()));
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
