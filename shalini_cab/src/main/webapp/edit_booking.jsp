<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Bean.BillBean" %>

<%
    BillBean booking = (BillBean) request.getAttribute("booking");
%>

<html>
<head>
    <title>Edit Booking</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { width: 50%; background: white; padding: 20px; margin: auto; margin-top: 50px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        label { font-weight: bold; }
        input, select { width: 100%; padding: 8px; margin: 5px 0; }
        .btn { padding: 10px; text-decoration: none; border-radius: 5px; cursor: pointer; }
        .save { background-color: green; color: white; }
        .cancel { background-color: red; color: white; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Edit Booking</h2>
        <form action="UpdateBookingServlet" method="post">
            <input type="hidden" name="id" value="<%= booking.getId() %>">
            
            <label>Username:</label>
            <input type="text" name="username" value="<%= booking.getUsername() %>" required>

            <label>Phone Number:</label>
            <input type="text" name="phoneNumber" value="<%= booking.getPhoneNumber() %>" required>

            <label>Pickup Location:</label>
            <input type="text" name="pickupLocation" value="<%= booking.getPickupLocation() %>" required>

            <label>Drop Location:</label>
            <input type="text" name="dropLocation" value="<%= booking.getDropLocation() %>" required>

            <label>Cab:</label>
            <input type="text" name="cab" value="<%= booking.getCab() %>" required>

            <label>Distance (Km):</label>
            <input type="number" name="distance" value="<%= booking.getDistance() %>" required>

            <br><br>
            <button type="submit" class="btn save">Save Changes</button>
            <a href="bills.jsp" class="btn cancel">Cancel</a>
        </form>
    </div>

</body>
</html>
