package com.codegym.service.impl;

import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import entities.Category;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Product> products = new ArrayList<>();
    private static CategoryService categoryService = new CategoryServiceImpl();
    static {
        products.add(new Product(1, "iPhone XR", categoryService.findById(1)));
        products.add(new Product(2, "iPhone Xs Max", categoryService.findById(1)));
        products.add(new Product(3, "Samsung Galaxy Note 10", categoryService.findById(2)));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public Product save(Product entity) {
        products.add(entity);
        return entity;
    }

    @Override
    public Product update(Product entity) {
        for (Product p : products) {
            if(p.getId() == entity.getId()) {
                p = entity;
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        for (Product p : products) {
            if(p.getId() == id) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Product entity) {
        return false;
    }


    @Override
    public List<Product> findByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findByCategoryName(String name) {
        return null;
    }
}
