package com.example.servlet;

import com.example.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/addCategorie")
public class AddCategoryServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("My-PU");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction( ).begin( );

        Category category= em.find(Category.class, 1);

        entityManager.persist(category);
        entityManager.getTransaction( ).commit( );

        entityManager.close( );
        emfactory.close( );
    }

    @Override
    public void destroy() {
        Process em = null;
        em.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category= new Category();
        category.setName(req.getParameter("name"));

        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Category category = em.find(Category.class, 1);
            em.remove(category);
            et.commit();
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }finally {
            em.close();
        }


        resp.sendRedirect( req.getContextPath() + "/auth/listProduct");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }
}
