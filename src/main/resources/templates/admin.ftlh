<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1>Library</h1>
<hr>
<h4>Panel of administrator</h4>
<table border="1">
    <tr>
        <th>Email</th>

        <th>Active</th>
        <th>Roles</th>
        <th>Ban</th>
        <th>Edit</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="submit" value="Ban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
        </tr>
    <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>