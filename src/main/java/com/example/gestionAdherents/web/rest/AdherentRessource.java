package com.example.gestionAdherents.web.rest;

import com.example.gestionAdherents.service.IAdherentIService;
import com.example.gestionAdherents.service.dto.AdherentDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/adherents")
@Tag(name = "adherent")
public class AdherentRessource {

    private final Logger log = LoggerFactory.getLogger(AdherentRessource.class);

    private static final String ENTITY_NAME = "cantineCantine";

    private final IAdherentIService service;

    public AdherentRessource(IAdherentIService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody AdherentDTO dto){
        log.debug("REST request to save Cantine : {}", dto);
        if (dto.getId() != null) {
            return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody AdherentDTO dto) {
        log.debug("REST request to save Cantine : {}", dto);
        if (dto.getId() == null) {
           return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AdherentDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdherentDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/utilisateur/{utilisateur-id}")
    public ResponseEntity<List<AdherentDTO>> findAllByUtilisateurId(@PathVariable("utilisateur-id") String utilisateurId){
        return ResponseEntity.ok(service.findAllByUtilisateurId(utilisateurId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
