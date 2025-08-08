package com.shiburaj.DOA;

import com.shiburaj.models.Todo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDOA {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public TodoDOA() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Todo> listAllTodos() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        String query = "SELECT * FROM todos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setStatus(rs.getString("status"));
                todos.add(todo);
            }
        }
        return todos;
    }

    public boolean addTodo(Todo todo) throws SQLException {
        String query = "INSERT INTO todos (title, status) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, todo.getTitle());
            pstmt.setString(2, todo.getStatus());
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                return false; // No rows inserted
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTodo(int id) throws SQLException {
        String query = "DELETE FROM todos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                return false; // No rows deleted
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean completeTodo(int id) throws SQLException {
        String query = "UPDATE todos SET status = 'completed' WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                return false; // No rows updated
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Todo getTodoById(int id) throws SQLException {
        String query = "SELECT * FROM todos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Todo todo = new Todo();
                    todo.setId(rs.getInt("id"));
                    todo.setTitle(rs.getString("title"));
                    todo.setStatus(rs.getString("status"));
                    return todo;
                }
            }
        }
        return null; // No todo found with the given ID
    }

    public boolean updateTodo(int id, Todo todo) throws SQLException {
        String query = "UPDATE todos SET title = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, todo.getTitle());
            pstmt.setString(2, todo.getStatus());
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            if (rows == 0) {
                return false; // No rows updated
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
