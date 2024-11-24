<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/client/register" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${client.name}" required><br>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="${client.email}" required><br>

    <label for="bmi">BMI:</label>
    <input type="number" name="bmi" id="bmi" value="${client.bmi}" step="0.1" required><br>

    <button type="submit">Register</button>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
