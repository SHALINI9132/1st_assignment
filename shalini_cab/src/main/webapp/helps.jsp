<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Help & Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            width: 50%;
            margin: auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        .navbar { background-color: #333; overflow: hidden; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; }
        .navbar a:hover { background-color: #575757; }
        
        h2 {
            color: #333;
        }
        p {
            font-size: 18px;
            color: #555;
        }
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
    <br><br><br><br>
     <div class="spacer"></div> <!-- Added extra space -->
      <div class="spacer"></div> <!-- Added extra space -->
	
<div class="container">
    <h2>Help & Support</h2>

    <h3>1. How to Book</h3>
    <p>On the Home page, there is a booking form. Fill in all the details and click the "Submit" button. Your booking will be successfully processed.</p>

    <h3>2. Contact Us</h3>
    <p>You can reach us through our official email: <strong>admin@gmail.com</strong></p>
    <p>Hotline Number: <strong>0777777777</strong></p>
</div>

</body>
</html>
