package com.codegym.view;

import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import com.codegym.service.impl.CategoryServiceImpl;
import com.codegym.service.impl.ProductServiceImpl;
import entities.Category;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductService productService = new ProductServiceImpl();
    private static CategoryService categoryService = new CategoryServiceImpl();
    private static ProductView productView = new ProductView();


    public static void main(String[] args) {
        System.out.println("WELCOME TO PRODUCT MANAGEMENT SYSTEM");
        System.out.println("PLEASE SELECT ACTION");
        System.out.println("--------------------------------------------------------------");
        int selection = 0;
        boolean exit = false;
        do {
            try {
                System.out.println("1. Manage Product");
                System.out.println("2. Manage Category");
                System.out.println("3. Exit");
                Scanner scanner = new Scanner(System.in);
                selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        showProductMenu();
                        break;
                    case 2:
                        showCategoryMenu();
                        break;
                    case 3:
                        System.out.println("Bye");
                        return;
                    default:
                        System.out.println("Invalid Input. Please try again");
                        break;
                }


            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please try again");
            }
        } while (selection != 3);
    }

    private static void showProductMenu() throws NumberFormatException{
        System.out.println("--------------------------------------------------------------");
        System.out.println("0. View all Products");
        System.out.println("1. View a product by ID");
        System.out.println("2. Search Products by Name");
        System.out.println("3. Insert a Product");
        System.out.println("4. Update a Product");
        System.out.println("5. Delete a Product");
        System.out.println("6. Back");
        Scanner scanner = new Scanner(System.in);
        int selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case 0:
                productView.showListProduct(productService.findAll());
                break;
            case 1:
                System.out.println("Please enter ID: ");
                selection = Integer.parseInt(scanner.nextLine());
                System.out.println(productService.findById(selection));
                break;
            case 2:
                System.out.println("Please enter name to search: ");
                String keyword = scanner.nextLine();
                productView.showListProduct(productService.findByName(keyword));
                break;
            case 3:
                productService.save(createProduct());
                break;
            case 4:
                System.out.println(updateProduct());
                break;
            case 5:
                deleteProduct();
                break;
        }
    }

    private static void showCategoryMenu() {
        System.out.println("Maintaining");
    }

    private static Product createProduct() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Pleas enter Product name");
        String name = scanner.nextLine();
        boolean foundCategory = false;
        Category category = new Category();
        do {
            System.out.println("Please enter Category ID");
            int categoryID = Integer.parseInt(scanner.nextLine());
            category = categoryService.findById(categoryID);
            if(category != null) {
                foundCategory = true;
            }
        } while (!foundCategory);
        return new Product(id, name, category);
    }

    private static Product updateProduct() throws NumberFormatException {
        Product product = createProduct();
        return productService.update(product);
    }

    private static void deleteProduct() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter ID");
        int id = Integer.parseInt(scanner.nextLine());
        if(productService.findById(id) == null) {
            System.out.println("Product not found");
        } else {
            productService.deleteById(id);
            System.out.println("Product is deleted");
        }
    }

}
