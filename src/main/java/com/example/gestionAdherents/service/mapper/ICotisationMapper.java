package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.Cotisations;
import com.example.gestionAdherents.service.dto.CotisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {IAdherentMapper.class, IVersementMapper.class})
public interface ICotisationMapper extends IMapperEntity<CotisationDTO, Cotisations>{
    @Mapping(source = "utilisateur.id",target = "utilisateurId")
    CotisationDTO toDto(Cotisations transaction);

    @Mapping(source = "utilisateurId",target = "utilisateur.id")
    Cotisations toEntity(CotisationDTO dto);
}
