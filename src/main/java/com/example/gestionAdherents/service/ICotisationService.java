package com.example.gestionAdherents.service;

import com.example.gestionAdherents.service.dto.CotisationDTO;

import java.util.List;

public interface ICotisationService extends IServiceEntity <CotisationDTO>{
    List<CotisationDTO> findAllByUtilisateurId(String utilisateurId);
}
