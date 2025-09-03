package com.shiburaj.Api;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;
import com.shiburaj.DOA.TodoDOA;
import com.shiburaj.models.Todo;
import java.sql.SQLException;



@WebServlet("/api/todo/*")
public class ListOneTodoServlet extends HttpServlet { 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        // Use Gson
        PrintWriter out = response.getWriter();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.length() > 1) {
            String idstr = pathInfo.substring(1); // remove leading '/'
            try {
                int id = Integer.parseInt(idstr);
                TodoDOA todoDOA = new TodoDOA();
                Todo todo = todoDOA.getTodoById(id);
                String json = new Gson().toJson(todo);
                out.println(json);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"error\":\"Invalid Todo ID format\"}");
            } catch (SQLException e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.println("{\"error\":\"Database error occurred\"}");
            }
        } else {
            out.println("No Todo ID provided");
        }
        
        
        out.flush();
    }
}
