<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
</head>
<body>
<h1>Library</h1><hr>
<h4>More info about book</h4>

<b>Name of book: </b> ${book.title}<br>
<b>Author: </b> ${book.author}<br>
<b>isbn: </b> ${book.isbn}<br>
<b>Available copies: </b> ${book.available_copies}<br>



<hr>
<#if user.isAdmin()>
    <h3> Delete book</h3>
    <form action="/books/delete/${book.id}" method="post">
        <input type="submit" value="Delete book"/>
    </form>
</#if>
<br>
<form action="/books/take/${book.id}" method="post">
    <input type="submit" value="Take a book"/>
</form>
</body>

</html>