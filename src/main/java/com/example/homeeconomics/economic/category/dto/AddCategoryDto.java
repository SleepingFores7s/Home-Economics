package com.example.homeeconomics.economic.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddCategoryDto {

    @NotBlank(message = "Category name can not be empty")
    @Size(min = 1, max = 100, message = "Category name must be between 1-100 characters long")
    private String category;

    public String getCategory() {
        return category;
    }
}
