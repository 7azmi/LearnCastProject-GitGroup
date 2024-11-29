<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Fitness Program</title>
</head>
<body>
<h2>Add New Program</h2>
<form action="/admin/addProgram" method="post">
    <label for="name">Program Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="duration">Duration (weeks):</label>
    <input type="number" id="duration" name="duration" required><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>

    <button type="submit">Add Program</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<c:if test="${not empty success}">
    <p style="color:green">${success}</p>
</c:if>
</body>
</html>
