package com.example.gestionAdherents.service;

import com.example.gestionAdherents.service.dto.RecetteDTO;

import java.util.List;

public interface IRecetteService extends IServiceEntity<RecetteDTO>{
    List<RecetteDTO> findAllByUtilisateurId(String utilisateurId);
}
