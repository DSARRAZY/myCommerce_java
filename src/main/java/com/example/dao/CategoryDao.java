package com.example.dao;

import com.example.entity.Category;

import java.util.List;

public interface CategoryDao {

    boolean create(Category category);
    List<Category> findAll();

}
