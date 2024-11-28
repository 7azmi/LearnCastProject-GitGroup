<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile</title>
</head>
<body>
<h1>Client Profile</h1>
<form action="/client/updateProfile" method="post">
    <p>Name: <input type="text" name="name" value="${client.name}" /></p>
    <p>Email: <input type="email" name="email" value="${client.email}" readonly /></p>
    <p>BMI: <input type="text" name="bmi" value="${client.bmi}" readonly /></p>
    <button type="submit">Update Profile</button>
</form>
</body>
</html>
