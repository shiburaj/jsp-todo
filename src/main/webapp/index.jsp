<%@ page import="com.shiburaj.models.Todo, com.shiburaj.DOA.TodoDOA, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>To-Do List App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .completed {
      background-color: #e2fde9;
    }
    .completed td {
      text-decoration: line-through;
      color: #6c757d;
      background-color: #e2fde9;

    }
  </style>
</head>
<body>
  <div class="container my-5">
    <h2 class="text-center mb-4">My To-Do List</h2>
    <div class="text-center mb-4">
      <a class="btn btn-primary mb-4" href="new.jsp">+ Add New Todo</a>
      <jsp:include page="messages.jsp" />
    </div>
    

    <!-- Task List Table -->
    <div class="card">
      <div class="card-header">Your Tasks</div>
      <div class="card-body p-0">
        
        <table class="table table-bordered m-0">
          <thead class="table-light">
            <tr>
              <th>#</th>
              <th>Todo Task</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <!-- Replace with dynamic rows using JSP or backend -->
            <%
                TodoDOA todoDOA = new TodoDOA();
                List<Todo> todos = (List<Todo>) todoDOA.listAllTodos();
                if (todos != null) {
                    for (Todo todo : todos) {
            %>
            <tr class="<%= todo.getStatus() %>">
              <td><%= todo.getId() %></td>
              <td><%= todo.getTitle() %></td>
              <td><%= todo.getStatus() %></td>
              <td>
                <% if (!todo.getStatus().equals("completed")) { %>
                  <a href="complete-task?id=<%= todo.getId() %>" class="btn btn-sm btn-success">Complete</a>
                <% } %>
                <a href="edit.jsp?id=<%= todo.getId() %>" class="btn btn-sm btn-warning">Edit</a>
                <a href="delete-task?id=<%= todo.getId() %>" class="btn btn-sm btn-danger">Delete</a>
              </td>
            </tr>
            <%
                    }
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