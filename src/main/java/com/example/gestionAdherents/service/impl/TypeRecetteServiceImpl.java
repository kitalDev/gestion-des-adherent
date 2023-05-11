package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.repository.TypeRecetteRepository;
import com.example.gestionAdherents.service.ITypeRecetteService;
import com.example.gestionAdherents.service.dto.TypeRecetteDTO;
import com.example.gestionAdherents.service.mapper.ITypeRecetteMapper;
import com.example.gestionAdherents.validation.ObjectValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TypeRecetteServiceImpl implements ITypeRecetteService {
    private final TypeRecetteRepository repository;
    private final ITypeRecetteMapper mapper;
    private final ObjectValidator<TypeRecetteDTO> validator;

    public TypeRecetteServiceImpl(TypeRecetteRepository repository, ITypeRecetteMapper mapper, ObjectValidator<TypeRecetteDTO> validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional
    public String save(TypeRecetteDTO dto) {
        validator.validate(dto);
        return repository.saveAndFlush(
                        mapper.toEntity(dto)
        ).getId();
    }

    @Override
    public List<TypeRecetteDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    @Override
    public TypeRecetteDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Adhérent de id "+id+" n'est trouvé"))
        );
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
