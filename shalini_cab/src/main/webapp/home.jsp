<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home - Mega City Cab System</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .navbar { background-color: #333; overflow: hidden; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; }
        .navbar a:hover { background-color: #575757; }
        .container { width: 50%; background: white; padding: 20px; margin: auto; margin-top: 30px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        .spacer { height: 30px; } /* Added space */
        input, select { width: 90%; padding: 8px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }
        button { background-color: blue; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: darkblue; }
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
        <h2>Welcome to Mega City Cab System</h2>
        <p>Book a cab easily with our system.</p>

        <div class="spacer"></div> <!-- Added extra space -->

        <h3>Book a Cab</h3>
        <form action="BookingServlet" method="post">
            <input type="text" name="username" placeholder="Username" required><br>
            <input type="text" name="phone_number" placeholder="Phone Number" required><br>
            <input type="text" name="pickup_location" placeholder="Pickup Location" required><br>
            <input type="text" name="drop_location" placeholder="Drop Location" required><br>
            <select name="cab">
                <option value="Cab 1">Cab 1</option>
                <option value="Cab 2">Cab 2</option>
                <option value="Cab 3">Cab 3</option>
                <option value="Cab 4">Cab 4</option>
                <option value="Cab 5">Cab 5</option>
            </select><br>
            <input type="number" name="distance" placeholder="Distance in Km" required><br>
            <button type="submit">Book Now</button>
        </form>
    </div>

</body>
</html>
