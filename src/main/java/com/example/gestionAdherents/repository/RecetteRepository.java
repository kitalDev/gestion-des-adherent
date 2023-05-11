package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.Adherent;
import com.example.gestionAdherents.domain.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, String> {
    List<Recette> findAllByUtilisateurId(String utilisateurId);
}
