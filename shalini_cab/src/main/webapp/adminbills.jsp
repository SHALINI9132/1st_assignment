<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Admin Bills</title>
    <link rel="stylesheet" type="text/css" href="admin_bills.css">
    <style>
        /* Full-height sidebar */
        .sidebar {
            height: 100vh; /* Full height */
            width: 200px; /* Sidebar width */
            position: fixed; /* Fixed sidebar */
            left: 0;
            top: 0;
            background-color: #333; /* Dark background */
            padding-top: 20px;
        }

        /* Sidebar links */
        .sidebar a {
            display: block;
            color: white;
            padding: 15px;
            text-decoration: none;
            font-size: 18px;
        }

        /* Hover effect */
        .sidebar a:hover {
            background-color: #575757;
        }

        /* Main content */
        .main-content {
            margin-left: 220px; /* Adjust margin based on sidebar width */
            padding: 20px;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #444;
            color: white;
        }
    </style>   
</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <a href="adminHome.jsp">🏠 Home</a>
        <a href="adminbills.jsp">📜 Bills</a>
        <a href="adminlogout.jsp">🚪 Logout</a>
    </div>

    <!-- Main content -->
    <div class="main-content">
        <h1>Booking Details</h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Phone Number</th>
                <th>Pickup Location</th>
                <th>Drop Location</th>
                <th>Cab</th>
                <th>Distance (Km)</th>
                <th>Total Amount</th>
            </tr>

            <%
                // Database connection details
                String url = "jdbc:mysql://localhost:3306/project"; 
                String user = "root";  
                String password = "123456789";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    String query = "SELECT * FROM booked_details";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        int distance = rs.getInt("distance");
                        int totalAmount = (distance * 6) + 500; // Amount formula
            %>
                        <tr>
                            <td><%= rs.getInt("id") %></td>
                            <td><%= rs.getString("username") %></td>
                            <td><%= rs.getString("phone_number") %></td>
                            <td><%= rs.getString("pickup_location") %></td>
                            <td><%= rs.getString("drop_location") %></td>
                            <td><%= rs.getString("cab") %></td>
                            <td><%= distance %></td>
                            <td>Rs. <%= totalAmount %></td>
                        </tr>
            <%
                    }

                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
            %>
                    <tr>
                        <td colspan="8">Error fetching data. Check console logs.</td>
                    </tr>
            <%
                }
            %>

        </table>
    </div>

</body>
</html>
