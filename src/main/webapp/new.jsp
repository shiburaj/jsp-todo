<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>To-Do List App</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container my-5">
    <h2 class="text-center mb-4">Add New Todo</h2>

    

    <!-- Add Task Form -->
    <div class="card mb-4">
      <div class="card-header">Add New Task</div>
      <div class="card-body">
        <form action="add-todo" method="POST">
          <jsp:include page="messages.jsp" />
          <div class="mb-3">
            <label for="taskTitle" class="form-label">Todo Task</label>
            <input type="text" class="form-control" id="taskTitle" name="title"  required>
          </div>

          <div class="mb-3">
            <button type="submit" class="btn btn-primary">Add Task</button>
            <a href="index.jsp" class="btn btn-secondary">Cancel</a>
        </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>