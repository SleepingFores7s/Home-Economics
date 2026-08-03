package com.example.homeeconomics.economic.category.service;

import com.example.homeeconomics.core.exception.customexceptions.ObjectAlreadyExistsException;
import com.example.homeeconomics.economic.category.dto.AddCategoryDto;
import com.example.homeeconomics.economic.category.entity.Category;
import com.example.homeeconomics.economic.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(AddCategoryDto dto) {

        //TODO make method return a dto instead of the object/entity

        if (categoryRepository.categoryExistByName(dto.getCategory())) {
            throw new ObjectAlreadyExistsException("Category with name " + dto.getCategory() + " already exists");
        }

        Category newCategory = new Category(dto.getCategory());
        return categoryRepository.save(newCategory);
    }

    public List<Category> getAllCategories() {

        try {
            return categoryRepository.findAll();
        }catch (Exception e){
            throw new Exception("Something went wrong, could not return categoru list.");
        }
    }
}
