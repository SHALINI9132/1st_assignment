<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Customer Registration</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }
        .container { width: 40%; background: white; padding: 20px; margin: auto; margin-top: 50px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        input { width: 90%; padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }
        button { background-color: blue; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: darkblue; }
        .message { color: green; font-weight: bold; margin-bottom: 10px; }
        .error { color: red; font-weight: bold; margin-bottom: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Registration</h2>
        
        <% if (request.getAttribute("message") != null) { %>
            <p class="<%= request.getAttribute("message").equals("Registration successful!") ? "message" : "error" %>">
                <%= request.getAttribute("message") %>
            </p>
        <% } %>

        <form action="CustomerServlet" method="post">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="email" name="mail_id" placeholder="Mail ID" required><br>
            <input type="text" name="phone_number" placeholder="Phone Number" required><br>
            <input type="text" name="address" placeholder="Address" required><br>
            <input type="text" name="nic_number" placeholder="NIC Number" required><br>
            <button type="submit">Register</button>
        </form>
        <p>Already registered? <a href="login.jsp">Please login</a></p>
    </div>
</body>
</html>
