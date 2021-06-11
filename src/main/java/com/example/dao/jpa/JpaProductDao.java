package com.example.dao.jpa;

import com.example.dao.ProductDao;
import com.example.entity.Product;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaProductDao implements ProductDao {

    private final EntityManagerFactory emf;
    public JpaProductDao(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void removeById(Long id) {

    }
}
