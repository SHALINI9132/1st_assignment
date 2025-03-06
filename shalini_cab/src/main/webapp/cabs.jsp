<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cabs</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        
        .cab-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 20px;
        }
        .cab-card {
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            background: #fff;
        }
        .cab-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .cab-card h5 {
            padding: 10px;
            background: #007bff;
            color: white;
            margin: 0;
        }
        .cab-card p {
            padding: 10px;
            font-size: 14px;
        }
        .navbar { background-color: #333; overflow: hidden; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; }
        .navbar a:hover { background-color: #575757; }
        
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
        <h2 class="text-center mt-4">Available Cabs</h2>
        
        <div class="cab-container">
            <!-- Cab 1 -->
            <div class="cab-card">
                <img src="images/cab1.png" alt="Cab 1">
                <h5>Cab 1</h5>
                
            </div>

            <!-- Cab 2 -->
            <div class="cab-card">
                <img src="images/cab2.png" alt="Cab 2">
                <h5>Cab 2</h5>
                
            </div>

            <!-- Cab 3 -->
            <div class="cab-card">
                <img src="images/cab3.png" alt="Cab 3">
                <h5>Cab 3</h5>
                
            </div>

            <!-- Cab 4 -->
            <div class="cab-card">
                <img src="images/cab4.png" alt="Cab 4">
                <h5>Cab 4</h5>
                
            </div>

            <!-- Cab 5 -->
            <div class="cab-card">
                <img src="images/cab5.jpg.png" alt="Cab 5">
                <h5>Cab 5</h5>
                
            </div>
        </div>
    </div>

</body>
</html>
