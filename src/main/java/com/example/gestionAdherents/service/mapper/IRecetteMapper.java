package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.Recette;
import com.example.gestionAdherents.service.dto.RecetteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring", uses = {IAdherentMapper.class, IVersementMapper.class, ITypeRecetteMapper.class})
public interface IRecetteMapper extends IMapperEntity<RecetteDTO, Recette>{
    @Mapping(source = "utilisateur.id",target = "utilisateurId")
    RecetteDTO toDto(Recette transaction);

    @Mapping(source = "utilisateurId",target = "utilisateur.id")
    Recette toEntity(RecetteDTO dto);
}
