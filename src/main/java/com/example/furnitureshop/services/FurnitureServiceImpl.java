package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.repositories.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> findAll() {
        return furnitureRepository.findAll()
                .stream()
                .filter(f -> !f.isDeleted())
                .collect(Collectors.toList());
    }
    @Override
    public Furniture findById(Long id) {
        if (id != null && id < 0){
            return furnitureRepository.findById(0L).orElse(null);
        }
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public Long create(Furniture furniture) {
        return furnitureRepository.save( furniture ).getId();
    }

    @Override
    public Furniture update(Long id, Furniture furniture) {


        Furniture furnitureForUpdate = furnitureRepository.findById( id ).orElse( null );

        if ( furnitureForUpdate != null )
        {
            furnitureForUpdate.setName( furniture.getName() );
            furnitureForUpdate.setDescription( furniture.getDescription() );
            furnitureForUpdate.setProducer( furniture.getProducer() );
            furnitureForUpdate.setPrice( furniture.getPrice() );
            furnitureForUpdate.setAvailableAmount( furniture.getAvailableAmount() );
            furnitureRepository.save( furnitureForUpdate );
        }
        return furnitureForUpdate;
    }

@Override
@Transactional
public boolean delete(Long id) {
    if (!furnitureRepository.existsById(id))
        return false;
    Furniture f = furnitureRepository.getOne(id);
    f.setDeleted(true);
    furnitureRepository.save(f);
    return true;
}
}
