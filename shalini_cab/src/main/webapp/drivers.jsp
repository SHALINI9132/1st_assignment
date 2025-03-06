<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Join as a Driver</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }
        .container { width: 40%; background: white; padding: 20px; margin: auto; margin-top: 50px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        .navbar { background-color: #333; overflow: hidden; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; }
        .navbar a:hover { background-color: #575757; }
        input { width: 90%; padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }
        button { background-color: blue; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: darkblue; }
        .message { color: green; font-weight: bold; margin-bottom: 10px; }
        .error { color: red; font-weight: bold; margin-bottom: 10px; }
    </style>
</head>
<body>
	
	<!-- Navbar -->
    <div class="navbar">
        <a href="home.jsp">Home</a>
        <a href="drivers.jsp">Drivers</a>
        <a href="cabs.jsp">Cabs</a>
        <a href="helps.jsp">Helps</a>
        <a href="bills.jsp">Bills</a>
        <a href="settings.jsp">Settings</a>
        <a href="logout.jsp">Logout</a>
    </div>

    <div class="container">
        <h2>If you like to join as a driver, please fill the details....</h2>

        <% if (request.getAttribute("message") != null) { %>
            <p class="<%= request.getAttribute("message").equals("Registration successful!") ? "message" : "error" %>">
                <%= request.getAttribute("message") %>
            </p>
        <% } %>

        <form action="DriverServlet" method="post">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="text" name="phone_number" placeholder="Phone Number" required><br>
            <input type="text" name="license_number" placeholder="License Number" required><br>
            <input type="email" name="email" placeholder="Email Address" required><br>
            <button type="submit">Register</button>
        </form>
    </div>

</body>
</html>
