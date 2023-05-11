package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.RoleUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleUtilisateur, String> {
    Optional<RoleUtilisateur> findByNom(String roleNome);
}
