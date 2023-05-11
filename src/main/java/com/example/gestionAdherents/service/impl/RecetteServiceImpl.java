package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.repository.RecetteRepository;
import com.example.gestionAdherents.service.IRecetteService;
import com.example.gestionAdherents.service.dto.RecetteDTO;
import com.example.gestionAdherents.service.mapper.IRecetteMapper;
import com.example.gestionAdherents.validation.ObjectValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecetteServiceImpl implements IRecetteService {
    private final RecetteRepository repository;
    private final IRecetteMapper mapper;
    private final ObjectValidator<RecetteDTO> validator;

    public RecetteServiceImpl(RecetteRepository repository, IRecetteMapper mapper, ObjectValidator<RecetteDTO> validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional
    public String save(RecetteDTO dto) {
        validator.validate(dto);
        return
                repository.saveAndFlush(
                        mapper.toEntity(dto)
        ).getId();
    }

    @Override
    public List<RecetteDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    @Override
    public RecetteDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Recette de id "+id+" n'est trouvé"))
        );
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * @param utilisateurId
     * @return
     */
    @Override
    public List<RecetteDTO> findAllByUtilisateurId(String utilisateurId) {
        return mapper.toDto(repository.findAllByUtilisateurId(utilisateurId));
    }
}
