package com.example.servlet;

import com.example.dao.CategoryDao;
import com.example.dao.DaoFactory;
import com.example.dao.ProductDao;
import com.example.entity.Category;
import com.example.entity.Product;

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

@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setContent(req.getParameter("content"));
        String nprice = req.getParameter("price");
        Float lprice =0f;
        try{
            lprice = Float.parseFloat(nprice);
        }catch (Exception e){}
        product.setPrice(lprice);

        ProductDao productDao = DaoFactory.getProductDao();
        productDao.create(product);

        String ncategory = req.getParameter("ListCategory");
        Long ncategory2 = Long.parseLong(ncategory);

        CategoryDao productDao1  = DaoFactory.getCategoryDao();
        Category findCategory = productDao1.findById(ncategory2);
        findCategory.getProducts().add(product);

        resp.sendRedirect( req.getContextPath() + "/auth/listProduct");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category",DaoFactory.getCategoryDao().findAll());

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
//        rd.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MyProduct nproduct = new MyProduct();
//        nproduct.setName(req.getParameter("name"));
//        nproduct.setContent(req.getParameter("Content"));
//        String nprice = req.getParameter("price");
//        Float lprice =0f;
//        try{
//            lprice = Float.parseFloat(nprice);
//        }catch (Exception e){}
//
//        nproduct.setPrice(lprice);
//        DaoFactory.getMyProductDao().create(nproduct);
//        resp.sendRedirect( req.getContextPath() + "/auth/listProduct");
//
//    }
}
