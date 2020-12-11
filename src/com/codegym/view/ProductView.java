package com.codegym.view;

import entities.Product;

import java.util.List;

public class ProductView {
    public void showListProduct(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
