<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client List</title>
</head>
<body>
<h2>Registered Clients</h2>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>BMI</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.bmi}</td>
            <td>${client.role}</td>
            <td>
                <button>View</button>
                <button>Manage</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
