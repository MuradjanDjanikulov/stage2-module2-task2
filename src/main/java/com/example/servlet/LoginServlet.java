package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            // User not logged in, redirect to login page
            response.sendRedirect("/login.jsp");
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");

        } else {
            // User logged in, redirect to user hello page
            response.sendRedirect(request.getContextPath() +"/user/hello.jsp");
//            req.getRequestDispatcher("/user/hello.jsp").forward(req, resp);
//            getServletContext().getRequestDispatcher("/user/hello.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        List<String> users = Users.getInstance().getUsers();
        if (users.contains(login) && !password.isEmpty()) {
            // Login successful, set session attribute "user" and redirect to user hello page
            request.getSession().setAttribute("user", login);
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        } else {
            // Login failed, forward to login page
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}

