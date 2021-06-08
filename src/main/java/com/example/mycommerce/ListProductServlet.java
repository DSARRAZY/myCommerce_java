package com.example.mycommerce;

import com.example.mycommerce.MyProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MyProduct> products  = MyProductDao.getAllProducts();

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Afficher liste produit</title>");
        out.println("</head>");
        out.println("<body>");
        for (MyProduct p : products ) {
            out.println("<p>Les produits " + p.getName() + p.getContent() + p.getPrice() +" !</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
