package com.example.dao.jpa;

import com.example.dao.CategoryDao;
import com.example.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JpaCategoryDao implements CategoryDao {

    private final EntityManagerFactory emf;

    public JpaCategoryDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List findAll() {

        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("FROM Category");
        List categories = query.getResultList() ;
        return categories;
    }

}

