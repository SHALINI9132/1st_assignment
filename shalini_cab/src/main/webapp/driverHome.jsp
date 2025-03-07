<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("driverUsername") == null) {
        response.sendRedirect("driverLogin.jsp");
        return;
    }

    String dbURL = "jdbc:mysql://localhost:3306/project";
    String dbUser = "root";
    String dbPassword = "123456789";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Home</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; }
        table { width: 80%; margin: auto; border-collapse: collapse; }
        th, td { padding: 10px; border: 1px solid black; text-align: center; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Welcome, <%= session1.getAttribute("driverUsername") %>!</h1>
    <p>You are logged in as a driver.</p>

    <h2>Booking Details</h2>

    <table>
        <tr>
            <th>Booking ID</th>
            <th>Customer Name</th>
            <th>Phone Number</th>
            <th>Pickup Location</th>
            <th>Drop Location</th>
            <th>Cab</th>
            <th>Distance (km)</th>
            <th>Amount</th>
        </tr>

        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
                String sql = "SELECT * FROM booked_details";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                boolean hasData = false; // To check if data exists

                while (rs.next()) {
                    hasData = true;
        %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("username") %></td>
                        <td><%= rs.getString("phone_number") %></td>
                        <td><%= rs.getString("pickup_location") %></td>
                        <td><%= rs.getString("drop_location") %></td>
                        <td><%= rs.getString("cab") %></td>
                        <td><%= rs.getInt("distance") %></td>
                        <td><%= (rs.getInt("distance") * 6) + 500 %></td>
                    </tr>
        <%
                }

                if (!hasData) { // If no data is found, display a message
        %>
                    <tr>
                        <td colspan="8">No bookings available.</td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
        %>
                <tr>
                    <td colspan="8" style="color: red;">Error fetching data.</td>
                </tr>
        <%
            } finally {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            }
        %>
    </table>

    <br>
    <a href="driverLogout.jsp">Logout</a>
</body>
</html>
