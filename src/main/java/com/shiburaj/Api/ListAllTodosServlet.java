package com.shiburaj.Api;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;
import com.shiburaj.DOA.TodoDOA;
import com.shiburaj.models.Todo;
import java.sql.SQLException;
import java.util.List;



@WebServlet("/api/todos")
public class ListAllTodosServlet extends HttpServlet { protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        // Use Gson
        PrintWriter out = response.getWriter();
        try {
            TodoDOA todoDOA = new TodoDOA();
            List<Todo> todos = todoDOA.listAllTodos();
            String json = new Gson().toJson(todos);
            out.println(json);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\":\"Database error occurred\"}");
        }
        
        out.flush();
    }
}
