package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.TypeRecette;
import com.example.gestionAdherents.service.dto.TypeRecetteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITypeRecetteMapper extends IMapperEntity<TypeRecetteDTO, TypeRecette>{
}
