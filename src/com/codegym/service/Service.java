package com.codegym.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();

    List<T> findByName(String name);

    T findById(int id);

    T save(T entity);

    T update(T entity);

    boolean deleteById(int id);

    boolean delete(T entity);
}
