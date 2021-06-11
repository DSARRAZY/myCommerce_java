package com.example.servlet;

import com.example.dao.DaoFactory;
import com.example.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/listCategory")
public class ListCategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List category = DaoFactory.getCategoryDao().findAll();
        req.setAttribute("category", category);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listCategory.jsp");
        rd.forward(req, resp);

    }


}
