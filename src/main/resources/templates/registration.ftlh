<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1>Library</h1><hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    Username: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Register"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage} </h2>
</#if>
</body>
</html>