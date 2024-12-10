<!DOCTYPE html>
<html>
<head>
        <title>Library</title>
</head>
<body>
<h1>Library</h1><hr>
<#if user.email??>
    <h3>Name: <i>${user.name} </i></h3>
    <form action="/logout" method="post">
        <input type="submit" value="Sign out"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Panel of administrator</a>
    </#if>
<#else>
    <a href="/login">Sign in</a></h1>
</#if>

<h4>Books</h4>
<form action="/" method="get">
    Search by title: <input type = "text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list books as book>
    <#if book.available_copies?? && book.available_copies != 0>
        <div>
            <p><b>${book.title}</b> ${book.author} | <a href="/books/${book.id}">More... </a></p>
        </div>
    </#if>
</#list>
<#if user.email??>
    <hr>
    <h3> Add book</h3>
    <form action="/books/create" method="post">
        <label>
        Name of book:   <input type="text" name="title"/><br><br>
        Author:         <input type="text" name="author"/><br><br>
        ISBN:           <input type="text" name="isbn"/><br><br>
        <input type="submit" value="Add book"/>
        </label>
    </form>
</#if>
</body>

</html>