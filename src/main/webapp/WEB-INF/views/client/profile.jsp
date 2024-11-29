<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Client Profile</title>
</head>
<body>
<h2>Your Profile</h2>
<form action="/updateProfile" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${client.name}" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${client.email}" readonly><br>

    <label for="bmi">BMI:</label>
    <input type="text" id="bmi" name="bmi" value="${client.bmi}" readonly><br>

    <button type="submit">Update Profile</button>
</form>
</body>
</html>
