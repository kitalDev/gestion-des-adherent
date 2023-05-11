package com.example.gestionAdherents.service.mapper;

import com.example.gestionAdherents.domain.RoleUtilisateur;
import com.example.gestionAdherents.service.dto.RoleUtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRoleMapper extends IMapperEntity<RoleUtilisateurDTO, RoleUtilisateur>{
}
