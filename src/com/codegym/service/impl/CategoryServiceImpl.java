package com.codegym.service.impl;

import com.codegym.service.CategoryService;
import entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private static List<Category> categories = new ArrayList<>();
    static {
        categories.add(new Category(1, "iPhone"));
        categories.add(new Category(2, "Android"));
    }
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }

    @Override
    public Category findById(int id) {
        for (Category category : categories) {
            if(category.getId() == id) return category;
        }
        return null;
    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean delete(Category entity) {
        return false;
    }
}
