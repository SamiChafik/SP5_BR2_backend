package com.example.budget_manager.mapper;

import com.example.budget_manager.dto.CategoryDTO;
import com.example.budget_manager.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO toDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());

        return dto;
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        return category;
    }

    public void updateEntityFromDto(CategoryDTO categoryDTO, Category category) {
        if (categoryDTO == null || category == null) {
            return;
        }

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
    }
}