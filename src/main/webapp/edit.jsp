<%@ page import="com.shiburaj.models.Todo, com.shiburaj.DOA.TodoDOA" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>To-Do List App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container my-5">
    <h2 class="text-center mb-4">Edit Todo</h2>

    

    <!-- Add Task Form -->
    <div class="card mb-4">
      <div class="card-header">Edit Task</div>
      <div class="card-body">
        <jsp:include page="messages.jsp" />
        <%
          String id = request.getParameter("id");
          TodoDOA todoDOA = new TodoDOA();
          Todo todo = todoDOA.getTodoById(Integer.parseInt(id));
            if (todo == null) {
                response.sendRedirect("index.jsp?error=Todo not found");
                return;
            }
        %>
        <form action="update-task?id=<%= todo.getId() %>" method="POST">
          <div class="mb-3">
            <label for="taskTitle" class="form-label">Todo Task</label>
            <input type="text" class="form-control" id="taskTitle" name="title" value="<%= todo.getTitle() %>" required>
          </div>
            <div class="mb-3">
                <label for="taskStatus" class="form-label">Status</label>
                <select class="form-select" id="taskStatus" name="status" required>
                <option value="" disabled>Select Status</option>
                <option value="pending" <%= todo.getStatus().equals("pending") ? "selected" : "" %>>In Progress</option>
                <option value="completed" <%= todo.getStatus().equals("completed") ? "selected" : "" %>>Completed</option>
                </select>
            </div>
          <div class="mb-3">
            <button type="submit" class="btn btn-primary">Update Task</button>
            <a href="index.jsp" class="btn btn-secondary">Cancel</a>
        </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>