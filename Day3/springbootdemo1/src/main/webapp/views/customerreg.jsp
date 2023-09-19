<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
</head>
<body>
    <h1>Customer Registration</h1>
    <form action="savecustomer" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="first_Name" required><br>
        
        <!-- <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="last_Name" required><br> -->
        
        <!-- Add other customer fields here -->

        <input type="submit" value="Register">
    </form>
</body>
</html>
