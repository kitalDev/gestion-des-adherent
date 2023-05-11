package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, String> {
    List<Adherent> findAllByUtilisateurId(String utilisateurId);
}
