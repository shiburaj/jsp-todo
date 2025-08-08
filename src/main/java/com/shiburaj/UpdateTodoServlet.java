package com.shiburaj;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

import com.shiburaj.DOA.TodoDOA;
import com.shiburaj.models.Todo;

@WebServlet("/update-task")
public class UpdateTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        int id = Integer.parseInt(request.getParameter("id"));

        if (title == null || title.trim().isEmpty()) {
            response.sendRedirect("new.jsp?error=Title cannot be empty");
            return;
        }

        try {
            TodoDOA todoDOA = new TodoDOA();
            Todo todo = new Todo();
            todo.setTitle(title);
            todo.setStatus(status); // Default status

            boolean isUpdated = todoDOA.updateTodo(id, todo);
            if (isUpdated) {
                response.sendRedirect("index.jsp?success=Todo updated successfully");
            } else {
                response.sendRedirect("new.jsp?error=Failed to update todo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("new.jsp?error=Database error occurred");
        }

    }
}
