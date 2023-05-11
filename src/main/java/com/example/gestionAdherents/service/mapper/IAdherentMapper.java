package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.Adherent;
import com.example.gestionAdherents.service.dto.AdherentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface IAdherentMapper extends IMapperEntity<AdherentDTO, Adherent>{
    @Mapping(source = "utilisateur.id",target = "utilisateurId")
    AdherentDTO toDto(Adherent adherent);

    @Mapping(source = "utilisateurId",target = "utilisateur.id")
    Adherent toEntity(AdherentDTO dto);
}
