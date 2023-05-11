package com.example.gestionAdherents.service;

import com.example.gestionAdherents.service.dto.AuthentificationRequest;
import com.example.gestionAdherents.service.dto.AuthentificationResponse;
import com.example.gestionAdherents.service.dto.UtilisateurDTO;

public interface IUtilisateurService extends IServiceEntity<UtilisateurDTO>{
    AuthentificationResponse register(UtilisateurDTO dto);

    AuthentificationResponse authenticate(AuthentificationRequest authentificationRequest);
}
