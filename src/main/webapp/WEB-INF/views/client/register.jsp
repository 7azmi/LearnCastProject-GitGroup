<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
</head>
<body>
<h1>Client Registration</h1>
<form action="/client/register" method="post">
    <p>Name: <input type="text" name="name" required /></p>
    <p>Email: <input type="email" name="email" required /></p>
    <p>Password: <input type="password" name="password" required /></p>
    <button type="submit">Register</button>
    <p style="color: red;">${errorMessage}</p>
</form>
</body>
</html>
