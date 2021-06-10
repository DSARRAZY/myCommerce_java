package com.example.dao.jpa;

import com.example.dao.MyProductDao;
import com.example.model.MyProduct;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaMyProductDao implements MyProductDao {

    private final EntityManagerFactory emf;

    public JpaMyProductDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public boolean create(MyProduct product) {
        return false;
    }

    @Override
    public void update(MyProduct product) {

    }

    @Override
    public MyProduct findById(Long id) {
        return null;
    }

    @Override
    public List<MyProduct> findAll() {
        return null;
    }

    @Override
    public void remove(MyProduct product) {

    }

    @Override
    public void removeById(Long id) {

    }
}
