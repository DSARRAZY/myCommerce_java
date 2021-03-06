package com.example.app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns={"/auth/*"})
public class AuthenticateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession sc = request.getSession();
        if (sc.getAttribute("name") == null) {
            response.sendRedirect( (request.getContextPath() + "/login"));

        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
