<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File Hider</title>
    <link rel="stylesheet" href="css/hide.css">
</head>
<body>
    <div class="container">
        <h2>Hide a File</h2>
        <form action="Hide_file" method="post">
            <input type="text" name="filePath" placeholder="Enter file path" required>
            <input type="submit" value="Hide">
        </form>
    </div>
</body>
</html>
