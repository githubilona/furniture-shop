package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.repositories.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> findAll() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture findById(Long id) {
        if (id != null && id < 0){
            return furnitureRepository.findById(0L).orElse(null);
        }
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public Long create(Furniture Furniture) {
        return null;
    }

    @Override
    public Furniture update(Long id, Furniture Furniture) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
