package com.example.gestionAdherents.service;

import java.util.List;

public interface IServiceEntity<D>{
    String save(D dto);
    List<D> findAll();
   D findById(String id);
   void  deleteById( String id);
}
