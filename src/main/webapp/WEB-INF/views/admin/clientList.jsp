<!DOCTYPE html>
<html lang="en">
<head>
    <title>Client List</title>
</head>
<body>
<h1>Registered Clients</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>BMI</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.bmi}</td>
            <td>
                <a href="/admin/manageRoles?email=${client.email}">Manage Roles</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
