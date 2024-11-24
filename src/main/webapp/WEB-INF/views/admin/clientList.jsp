<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Client List</title>
</head>
<body>
<h1>Client List</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>BMI</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.bmi}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
