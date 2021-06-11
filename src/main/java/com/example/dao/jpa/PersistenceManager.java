package com.example.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceManager {

    private static final String EMF_KEY = "PU";

    // SINGLETON INSTANCE
    private static EntityManagerFactory emf;

    private PersistenceManager() {
        // Avoid instantiate
    }

    // Lazy initialization
    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("My-PU");
        }
        return emf;
    }

    public static EntityManagerFactory getConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(EMF_KEY);
        }
        return emf;
    }

    public static void closeConnection() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
