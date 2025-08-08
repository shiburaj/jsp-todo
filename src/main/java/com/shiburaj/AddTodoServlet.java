package com.shiburaj;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

import com.shiburaj.DOA.TodoDOA;
import com.shiburaj.models.Todo;

@WebServlet("/add-todo")
public class AddTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");

        if (title == null || title.trim().isEmpty()) {
            response.sendRedirect("new.jsp?error=Title cannot be empty");
            return;
        }

        try {
            TodoDOA todoDOA = new TodoDOA();
            Todo todo = new Todo();
            todo.setTitle(title);
            todo.setStatus("pending"); // Default status

            boolean isAdded = todoDOA.addTodo(todo);
            if (isAdded) {
                response.sendRedirect("index.jsp?success=Todo added successfully");
            } else {
                response.sendRedirect("new.jsp?error=Failed to add todo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("new.jsp?error=Database error occurred");
        }

    }
}
