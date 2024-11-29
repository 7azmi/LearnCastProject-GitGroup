<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Client Roles</title>
</head>
<body>
<h2>Manage Roles</h2>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${adminViewModel.clients}">
        <tr>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.role}</td>
            <td>
                <button>Assign Role</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
