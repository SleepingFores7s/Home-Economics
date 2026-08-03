package com.example.homeeconomics.economic.category.controller;

import com.example.homeeconomics.core.exception.customexceptions.ObjectAlreadyExistsException;
import com.example.homeeconomics.economic.category.dto.AddCategoryDto;
import com.example.homeeconomics.economic.category.service.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/category/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody AddCategoryDto Dto) {

        try {

            categoryService.addCategory(Dto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();

        }catch (ObjectAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }

    }

    @GetMapping("/api/category")
    public ResponseEntity<?> getAllCategories() {

        try{

            return ResponseEntity
                    .ok(categoryService.getAllCategories());

        }catch (Exception e) {
            return  ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

    }

}
