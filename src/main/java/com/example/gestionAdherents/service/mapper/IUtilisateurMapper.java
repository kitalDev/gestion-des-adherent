package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.Utilisateur;
import com.example.gestionAdherents.service.dto.UtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
public interface IUtilisateurMapper extends IMapperEntity<UtilisateurDTO, Utilisateur>{
}
