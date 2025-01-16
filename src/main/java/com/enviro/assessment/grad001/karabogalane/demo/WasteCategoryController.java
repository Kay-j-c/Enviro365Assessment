package com.enviro.assessment.grad001.karabogalane.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return service.getAllWasteCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> wasteCategory = service.getWasteCategoryById(id);
        return wasteCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WasteCategory createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return service.createWasteCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedCategory = service.updateWasteCategory(id, wasteCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        service.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
