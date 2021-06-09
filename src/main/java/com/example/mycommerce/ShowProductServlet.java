package com.example.mycommerce;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/show-product")
public class ShowProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = Long.valueOf(idStr);

        MyProduct products = MyProductDao.findProductById(id);
        req.setAttribute("product", products);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/showProduct.jsp");
        rd.forward(req, resp);

    }

}
