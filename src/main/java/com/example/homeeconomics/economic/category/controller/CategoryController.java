package com.example.homeeconomics.economic.category.controller;

import com.example.homeeconomics.economic.category.dto.AddCategoryDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/api/category/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody AddCategoryDto Dto) {



    }

}
