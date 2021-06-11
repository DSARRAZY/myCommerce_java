package com.example.dao.jdbc;

import com.example.dao.CategoryDao;
import com.example.entity.Category;

import java.util.List;

public class JdbcCategoryDao implements CategoryDao {

    @Override
    public List<Category>findAll() {
        return null;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void remove(Category category) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public boolean create (Category category) {
        return false;
    }

}
