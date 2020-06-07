package com.example.furnitureshop.controllers;

import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.services.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FurnitureController {

    private FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping
    public List<Furniture> findAll() {
        return furnitureService.findAll();
    }

    @GetMapping("/{id}")
    public Furniture findById(@PathVariable("id") Long id) {
        return furnitureService.findById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Furniture Furniture) {
        return furnitureService.create(Furniture);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Furniture Furniture) {
        furnitureService.update(id, Furniture);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        furnitureService.delete(id);
    }
}
