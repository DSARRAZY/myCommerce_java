package com.example.dao.jpa;

import com.example.dao.ProductDao;
import com.example.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaProductDao implements ProductDao {

    private final EntityManagerFactory emf;
    public JpaProductDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public boolean create(Product product) {
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(product);
            et.commit();
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
            return false;
        }finally {
            em.close();
        }
        return true;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("FROM Product");
        List product = query.getResultList();
        return product;
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void removeById(Long id) {

    }
}
