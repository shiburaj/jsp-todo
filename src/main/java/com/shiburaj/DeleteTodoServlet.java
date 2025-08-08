package com.shiburaj;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

import com.shiburaj.DOA.TodoDOA;

@WebServlet("/delete-task")
public class DeleteTodoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (id <= 0) {
            response.sendRedirect("index.jsp?error=Invalid Todo ID");
            return;
        }

        try {
            TodoDOA todoDOA = new TodoDOA();

            boolean isDeleted = todoDOA.deleteTodo(id);
            if (isDeleted) {
                response.sendRedirect("index.jsp?success=Todo deleted successfully");
            } else {
                response.sendRedirect("new.jsp?error=Failed to delete todo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("new.jsp?error=Database error occurred");
        }

    }
}
