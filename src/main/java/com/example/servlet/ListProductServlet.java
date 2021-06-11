package com.example.servlet;

import com.example.dao.DaoFactory;
import com.example.dao.MyProductDao;
import com.example.entity.Product;
import com.example.model.MyProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/listProduct")
public class ListProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = DaoFactory.getProductDao().findAll();
        req.setAttribute("products", products);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);

    }
}


//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Afficher liste produit</title>");
//        out.println("</head>");
//        out.println("<body>");
//        for (MyProduct p : products ) {
//            out.println("<p>Les produits " + p.getName() + p.getContent() + p.getPrice() +" !</p>");
//        }
//
//        HttpSession session = req.getSession();
//        resp.getWriter().println("Mon nom est :"+session.getAttribute("user"));
//
//        out.println("</body>");
//        out.println("</html>");


