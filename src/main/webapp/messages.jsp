
<% if(request.getParameter("success") != null) { %>
    <div class="alert alert-success">${param.success}</div>
<% } %>
<% if(request.getParameter("error") != null) { %>
    <div class="alert alert-danger">${param.error}</div>
<% } %>