package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.dao.MyProductDao;
import com.example.model.MyProduct;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct product = new MyProduct();
        product.setName("Montre");
        product.setContent("swatch");
        product.setPrice(150F);
        MyProductDao.addProduct(product);

        MyProduct product2 = new MyProduct();
        product2.setName("Bracelet");
        product2.setContent("or 18 carats");
        product2.setPrice(200F);
        MyProductDao.addProduct(product2);

        resp.sendRedirect( req.getContextPath() + "/listProduct");
    }

}
