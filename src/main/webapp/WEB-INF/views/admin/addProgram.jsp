<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Fitness Program</title>
</head>
<body>
<h1>Add Fitness Program</h1>
<form action="/admin/addProgram" method="post">
    <p>Name: <input type="text" name="name" value="${program.name}" required /></p>
    <p>Description: <input type="text" name="description" value="${program.description}" required /></p>
    <p>Duration (weeks): <input type="number" name="duration" value="${program.duration}" required /></p>
    <button type="submit">Add Program</button>
    <p style="color: red;">${errorMessage}</p>
    <p style="color: green;">${successMessage}</p>
</form>
</body>
</html>
