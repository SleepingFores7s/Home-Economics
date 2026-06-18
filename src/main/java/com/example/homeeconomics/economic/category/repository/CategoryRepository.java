package com.example.homeeconomics.economic.category.repository;

import com.example.homeeconomics.economic.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
