<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/client/login" method="post">
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" value="${client.email}" required><br>

    <button type="submit">Login</button>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
