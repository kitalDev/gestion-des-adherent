package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.Versement;
import com.example.gestionAdherents.service.dto.VersementDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IVersementMapper extends IMapperEntity<VersementDTO, Versement> {
}
