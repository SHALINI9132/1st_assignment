<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Bean.BillBean" %>
<%@ page import="Dao.BillDAO" %>
<html>
<head>
    <title>Billing - Mega City Cab System</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { width: 80%; background: white; padding: 20px; margin: auto; margin-top: 30px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid black; padding: 10px; text-align: center; }
        th { background-color: #333; color: white; }
        .btn { padding: 5px 10px; text-decoration: none; border-radius: 5px; }
        .edit { background-color: orange; color: white; }
        .delete { background-color: red; color: white; }
    </style>
</head>
<body>

    <div class="container">
        <h2>All Bookings</h2>
        <table>
            <tr>
                <th>Username</th>
                <th>Phone Number</th>
                <th>Pickup Location</th>
                <th>Drop Location</th>
                <th>Cab</th>
                <th>Distance (Km)</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
            <%
                BillDAO dao = new BillDAO();
                List<BillBean> bookings = dao.getAllBookings();
                for (BillBean booking : bookings) {
            %>
            <tr>
                <td><%= booking.getUsername() %></td>
                <td><%= booking.getPhoneNumber() %></td>
                <td><%= booking.getPickupLocation() %></td>
                <td><%= booking.getDropLocation() %></td>
                <td><%= booking.getCab() %></td>
                <td><%= booking.getDistance() %></td>
                <td><%= booking.getAmount() %></td>
                <td>
                    <a href="EditBookingServlet?id=<%= booking.getId() %>" class="btn edit">Edit</a>
                    <a href="DeleteBookingServlet?id=<%= booking.getId() %>" class="btn delete" onclick="return confirm('Are you sure?')">Cancel</a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>

</body>
</html>
