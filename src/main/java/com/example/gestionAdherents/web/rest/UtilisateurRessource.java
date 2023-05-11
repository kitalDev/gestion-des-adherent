package com.example.gestionAdherents.web.rest;

import com.example.gestionAdherents.service.IUtilisateurService;
import com.example.gestionAdherents.service.IVersementService;
import com.example.gestionAdherents.service.dto.UtilisateurDTO;
import com.example.gestionAdherents.service.dto.VersementDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/utilsateurs")
@Tag(name = "utilisateur")
public class UtilisateurRessource {
    private final IUtilisateurService service;

    public UtilisateurRessource(IUtilisateurService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody UtilisateurDTO dto){
        if (dto.getId()!= null){
            return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody UtilisateurDTO dto){
        if (dto.getId()==null){
            return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UtilisateurDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
