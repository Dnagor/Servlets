package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = UserService.getUserService();
        User user = userService.getUser(email);
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        if (user.getPassword().equals(password)) {
            request.setAttribute("Email", email);
            request.getRequestDispatcher("/cabinet.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
