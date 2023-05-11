package com.example.gestionAdherents.service;

import com.example.gestionAdherents.service.dto.AdherentDTO;

import java.util.List;

public interface IAdherentIService extends IServiceEntity<AdherentDTO> {
    List<AdherentDTO> findAllByUtilisateurId(String utilisateurId);
}
