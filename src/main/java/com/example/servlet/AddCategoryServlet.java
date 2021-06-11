package com.example.servlet;

import com.example.dao.CategoryDao;
import com.example.dao.DaoFactory;
import com.example.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category= new Category();
        category.setName(req.getParameter("name"));
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        categoryDao.create(category);

        resp.sendRedirect( req.getContextPath() + "/auth/listCategory");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }
}


