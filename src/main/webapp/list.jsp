<%@ page language="java" %>
<%@ page import="com.shiburaj.models.Todo, java.util.List, java.util.ArrayList" %>   
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>To-Do List App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container my-5">
    <h2 class="text-center mb-4">To-Do List</h2>
    <% 
      String message = request.getParameter("message");
      if (message != null) {
    %>
    <div class="alert alert-success" role="alert">
      <%= message %>
    </div>
    <% } %>
    <!-- Add Task Form -->
    <div class="card mb-4">
      <div class="card-header">Add New Task</div>
      <div class="card-body">
        <form method="POST" action="add-todo">
          <div class="mb-3">
            <label for="taskTitle" class="form-label">Task Title</label>
            <input type="text" class="form-control" id="taskTitle" name="title" required>
          </div>
          <div class="mb-3">
            <label for="taskDesc" class="form-label">Description</label>
            <textarea class="form-control" id="taskDesc" name="description" rows="2"></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Add Task</button>
        </form>
      </div>
    </div>

    <!-- Task List Table -->
    <div class="card">
      <div class="card-header">Your Tasks</div>
      <div class="card-body p-0">
        <table class="table table-bordered m-0">
          <thead class="table-light">
            <tr>
              <th>#</th>
              <th>Title</th>
              <th>Description</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <!-- Replace with dynamic rows using JSP or backend -->
            <% 
                for(Todo todo : request.getAttribute("todos") != null ? (List<Todo>) request.getAttribute("todos") : new ArrayList<Todo>()) {
            %>
            <tr>
              <td><%= todo.getId() %></td>
              <td><%= todo.getTitle() %></td>
              <td><%= todo.getDescription() %></td>
              <td>
                <a href="/edit-task?id=<%= todo.getId() %>" class="btn btn-sm btn-success">Complete</a>
                <a href="/edit-task?id=<%= todo.getId() %>" class="btn btn-sm btn-warning">Edit</a>
                <a href="/delete-task?id=<%= todo.getId() %>" class="btn btn-sm btn-danger">Delete</a>
              </td>
            </tr>
            <% 
                }
            %>
            <!-- Sample static row ends -->
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>