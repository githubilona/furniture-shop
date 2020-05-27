package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Furniture;

import java.util.List;

public interface FurnitureService {

    List<Furniture> findAll();

    Furniture findById(Long id);

    Long create(Furniture Furniture);

    Furniture update(Long id, Furniture Furniture);

    void delete(Long id);
}
