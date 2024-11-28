<!DOCTYPE html>
<html lang="en">
<head>
    <title>Manage Roles</title>
</head>
<body>
<h1>Manage Client Roles</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.clientName}</td>
            <td>${client.clientEmail}</td>
            <td>
                <form action="/admin/assignRole" method="post">
                    <input type="hidden" name="email" value="${client.clientEmail}" />
                    <select name="role">
                        <option value="USER" ${client.role == 'USER' ? 'selected' : ''}>User</option>
                        <option value="ADMIN" ${client.role == 'ADMIN' ? 'selected' : ''}>Admin</option>
                    </select>
                    <button type="submit">Update Role</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
