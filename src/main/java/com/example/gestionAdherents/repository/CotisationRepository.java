package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.Adherent;
import com.example.gestionAdherents.domain.Cotisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CotisationRepository extends JpaRepository<Cotisations, String> {
    List<Cotisations> findAllByUtilisateurId(String utilisateurId);
}
