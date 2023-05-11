package com.example.gestionAdherents.web.rest;

import com.example.gestionAdherents.service.IUtilisateurService;
import com.example.gestionAdherents.service.dto.AuthentificationRequest;
import com.example.gestionAdherents.service.dto.AuthentificationResponse;
import com.example.gestionAdherents.service.dto.UtilisateurDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthentificationRessource {
    private final IUtilisateurService service;

    @PostMapping("/register")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody UtilisateurDTO dto){
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthentificationResponse> authenticate(
            @RequestBody AuthentificationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
