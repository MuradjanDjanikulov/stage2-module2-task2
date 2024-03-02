package com.example.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Delete session attribute "user"
        request.getSession().removeAttribute("user");

        // Invalidate session
        request.getSession().invalidate();

        // Redirect to login page
        response.sendRedirect("/login.jsp");
    }
}

