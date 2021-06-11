package com.example.dao;

import com.example.entity.Category;

import java.util.List;

public interface CategoryDao {

    boolean create(Category category);

    List<Category> findAll();

    void update(Category category);

    Category findById(Long id);

    void remove(Category category);

    void removeById(Long id);


}
