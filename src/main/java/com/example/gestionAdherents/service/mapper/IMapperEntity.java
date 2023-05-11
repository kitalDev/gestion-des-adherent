package com.example.gestionAdherents.service.mapper;

import java.util.List;

public interface IMapperEntity <D, E> {
        D toDto( E entity);
        E toEntity( D dto);
        List<D> toDto( List<E> entityList);
        List<E> toEntity( List<D> entityList);
}
