package com.example.mycommerce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.mycommerce.MyProduct;
import com.example.mycommerce.MyProductDao;

public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct product = new MyProduct();
        product.setName("Montre");
        product.setContent("belle montre");
        product.setPrice(150F);
        MyProductDao.addProduct(product);
    }
}
