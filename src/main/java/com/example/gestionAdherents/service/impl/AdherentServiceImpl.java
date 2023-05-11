package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.repository.AdherentRepository;
import com.example.gestionAdherents.service.IAdherentIService;
import com.example.gestionAdherents.service.dto.AdherentDTO;
import com.example.gestionAdherents.service.mapper.IAdherentMapper;
import com.example.gestionAdherents.validation.ObjectValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdherentServiceImpl implements IAdherentIService {
    private final AdherentRepository repository;
    private final IAdherentMapper mapper;
    private final ObjectValidator<AdherentDTO> validator;
    public AdherentServiceImpl(AdherentRepository repository, IAdherentMapper mapper, ObjectValidator<AdherentDTO> validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional
    public String save(AdherentDTO dto) {
        validator.validate(dto);
        return repository.saveAndFlush(
                        mapper.toEntity(dto)
        ).getId();
    }

    @Override
    public List<AdherentDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    @Override
    public AdherentDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Adhérent de id "+id+" n'est trouvé"))
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
    public List<AdherentDTO> findAllByUtilisateurId(String utilisateurId) {
        return mapper.toDto(repository.findAllByUtilisateurId(utilisateurId));
    }
}
