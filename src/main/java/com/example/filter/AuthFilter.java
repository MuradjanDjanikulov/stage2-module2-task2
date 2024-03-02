package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = "/user/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        if (session.getAttribute("user") == null) {
            // User not logged in, redirect to login page
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            // User logged in, continue with the request
            chain.doFilter(request, response);
        }
    }

/*    @Override
    public void destroy() {
        // Cleanup code, if any
    }*/
}
