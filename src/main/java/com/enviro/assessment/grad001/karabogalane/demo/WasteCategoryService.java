package com.enviro.assessment.grad001.karabogalane.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> findAll() {
        return repository.findAll();
    }

    public WasteCategory save(WasteCategory wasteCategory) {
        return repository.save(wasteCategory);
    }
}