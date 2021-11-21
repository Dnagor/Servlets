package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class registration extends HttpServlet {
    private UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userService.saveUser(new User(name, lastname, email, password));
        request.setAttribute("FirstName", name);
        request.setAttribute("LastName", lastname);
        request.setAttribute("Email", email);
        request.getRequestDispatcher("/cabinet.jsp").forward(request, response);
    }
}
