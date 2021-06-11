package com.example.dao.jpa;

import com.example.dao.CategoryDao;
import com.example.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
        List categories = query.getResultList();
        return categories;
    }

    @Override
    public boolean create(Category category) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(category);
            et.commit();
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }


    @Override
    public Category findById(Long id) {
        EntityManager em = this.emf.createEntityManager();
        return em.find(Category.class,id);
        }




    @Override
    public void update(Category category) {

    }


    @Override
    public void remove(Category category) {

    }

    @Override
    public void removeById(Long id) {

    }
}

