package com.example.gestionAdherents.repository;

import com.example.gestionAdherents.domain.Versement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersementRepository extends JpaRepository<Versement, String> {
}
