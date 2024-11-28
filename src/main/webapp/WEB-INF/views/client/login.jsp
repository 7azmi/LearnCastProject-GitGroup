<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
</head>
<body>
<h1>Client Login</h1>
<form action="/client/login" method="post">
    <p>Email: <input type="email" name="email" required /></p>
    <p>Password: <input type="password" name="password" required /></p>
    <button type="submit">Login</button>
    <p style="color: red;">${errorMessage}</p>
</form>
</body>
</html>
