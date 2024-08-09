<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Management</title>
    <link rel="stylesheet" href="css/main_menu.css">
</head>
<body>
    <div class="container">
        <div class="instructions">
            <p>Welcome</p>
            <p>PRESS 1 TO SHOW HIDDEN FILES</p>
            <p>PRESS 2 TO HIDE A FILE</p>
            <p>PRESS 3 TO UNHIDE A FILE</p>
            <p>PRESS 0 TO EXIT</p>
        </div>
        <form action="main_menu" method="post">
            <input type="text" name="inputField" placeholder="Enter your choice" required>
            <input type="submit" value="Done">
        </form>
    </div>
</body>
</html>
