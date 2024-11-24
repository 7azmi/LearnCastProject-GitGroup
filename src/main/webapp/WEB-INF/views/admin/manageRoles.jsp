<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Manage Roles</title>
</head>
<body>
<h1>Manage Roles</h1>
<form action="/admin/manageRoles" method="post">
    <table border="1">
        <tr>
            <th>Client Name</th>
            <th>Role</th>
        </tr>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.name}</td>
                <td>
                    <select name="role">
                        <c:forEach var="role" items="${roles}">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Save Changes</button>
</form>
</body>
</html>
