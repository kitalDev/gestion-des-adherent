package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.repository.CotisationRepository;
import com.example.gestionAdherents.service.ICotisationService;
import com.example.gestionAdherents.service.dto.CotisationDTO;
import com.example.gestionAdherents.service.mapper.ICotisationMapper;
import com.example.gestionAdherents.validation.ObjectValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CotisationServiceImpl implements ICotisationService {
    private final CotisationRepository repository;
    private final ICotisationMapper mapper;
    private final ObjectValidator<CotisationDTO> validator;

    public CotisationServiceImpl(CotisationRepository repository, ICotisationMapper mapper, ObjectValidator<CotisationDTO> validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    @Transactional
    public String save(CotisationDTO dto) {
        validator.validate(dto);
        return repository.saveAndFlush(
                        mapper.toEntity(dto)
        ).getId();
    }

    @Override
    public List<CotisationDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    @Override
    public CotisationDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Adhérent de id "+id+" n'est trouvé"))
        );
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * @param utilisateurId
     * @return
     */
    @Override
    public List<CotisationDTO> findAllByUtilisateurId(String utilisateurId) {
        return mapper.toDto(repository.findAllByUtilisateurId(utilisateurId));
    }
}
