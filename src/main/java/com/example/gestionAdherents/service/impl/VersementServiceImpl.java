package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.repository.VersementRepository;
import com.example.gestionAdherents.service.IVersementService;
import com.example.gestionAdherents.service.dto.VersementDTO;
import com.example.gestionAdherents.service.mapper.IVersementMapper;
import com.example.gestionAdherents.validation.ObjectValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VersementServiceImpl implements IVersementService {
    private final VersementRepository repository;
    private final IVersementMapper mapper;
    private final ObjectValidator<VersementDTO> validator;

    public VersementServiceImpl(VersementRepository repository, IVersementMapper mapper, ObjectValidator<VersementDTO> validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional
    public String save(VersementDTO dto) {
        validator.validate(dto);
        return repository.saveAndFlush(
                        mapper.toEntity(dto)
                ).getId();
    }

    @Override
    public List<VersementDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    @Override
    public VersementDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Versement de id "+id+" n'est trouvé"))
        );
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
