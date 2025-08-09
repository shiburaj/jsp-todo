package com.shiburaj;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.jsp?error=Please fill in all fields");
            return;
        }
        if(email.equals("u@a.c") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("index.jsp?success=Login successful");
        } else {
            response.sendRedirect("login.jsp?error=Invalid email or password");
        }
    }
}
