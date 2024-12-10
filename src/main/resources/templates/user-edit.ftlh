<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1>Library</h1>
<hr>
<h3>Edit user ${user.name}</h3>
<form action="/admin/user/edit" method="post">
    <div>
        <label>Username: <input type="text" name="username" value="${user.name}"></label>
    </div>
    <div>
        <label>Email: <input type="email" name="email" value="${user.email}"></label>
    </div>
    <div>
        <label>Password: <input type="password" name="password"></label>
    </div>
    <h4>Role</h4>
    <div>
        <label for="role">Select Role:</label>
        <select name="role" id="role">
            <#list roles as role>
                <option value="${role}" ${user.roles?seq_contains(role)?string("selected", "")}>${role}</option>
            </#list>
        </select>
    </div>
    <input type="hidden" name="userId" value="${user.id}">
    <button type="submit">Save</button>
</form>
</body>
</html>
