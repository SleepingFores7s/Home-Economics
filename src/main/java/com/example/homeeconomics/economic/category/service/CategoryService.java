package com.example.homeeconomics.economic.category.service;

import com.example.homeeconomics.economic.category.entity.Category;
import com.example.homeeconomics.economic.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category){


        //TODO - make a check to see if the category already exists or not
        try{

            if(categoryRepository.)

        }catch (Exception e) {

        }

        return categoryRepository.save(category);
    }

}
