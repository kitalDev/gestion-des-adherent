package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.TypeRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRecetteRepository extends JpaRepository<TypeRecette, String> {
}
