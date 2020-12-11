package com.codegym.service;

import entities.Category;
import entities.Product;

import java.util.List;

public interface ProductService extends Service<Product> {
    List<Product> findByCategory(Category category);

    List<Product> findByCategoryName(String name);
}
