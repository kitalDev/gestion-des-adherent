package com.example.gestionAdherents.web.rest;

import com.example.gestionAdherents.service.ITypeRecetteService;
import com.example.gestionAdherents.service.dto.TypeRecetteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/type-recettes")
@Tag(name = "typerecette")
public class TypeRecetteRessource {
    private final ITypeRecetteService service;
    private final Logger log = LoggerFactory.getLogger(AdherentRessource.class);

    public TypeRecetteRessource(ITypeRecetteService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody TypeRecetteDTO dto){
        log.debug("REST request to save Cantine : {}", dto);
        if (dto.getId() == null) {
            return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody TypeRecetteDTO dto){
        log.debug("REST request to update Cantine : {}", dto);
         if (dto.getId() != null) {
            return null;
        }
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeRecetteDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeRecetteDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
