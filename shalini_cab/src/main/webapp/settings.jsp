<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, Dao.CustomerDAO, Bean.CustomerBean" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessionObj = request.getSession(false);
    String username = (String) sessionObj.getAttribute("username");

    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    CustomerDAO customerDAO = new CustomerDAO();
    CustomerBean customer = customerDAO.getCustomerByUsername(username);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Settings - Update Details</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
         .navbar { background-color: #333; overflow: hidden; padding: 15px; text-align: center; }
        .navbar a { color: white; text-decoration: none; padding: 14px 20px; display: inline-block; }
        .navbar a:hover { background-color: #575757; }
        .container { width: 40%; background: white; padding: 20px; margin: auto; margin-top: 50px; box-shadow: 0px 0px 10px gray; border-radius: 10px; }
        input, button { width: 100%; padding: 10px; margin-top: 10px; }
        button { background-color: green; color: white; border: none; cursor: pointer; }
        button:hover { background-color: darkgreen; }
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
        <h2>Update Your Details</h2>
        <form action="UpdateCustomerServlet" method="post">
            <label>Username:</label>
            <input type="text" name="username" value="<%= customer.getUsername() %>" readonly>

            <label>Password:</label>
            <input type="password" name="password" value="<%= customer.getPassword() %>" required>

            <label>Email:</label>
            <input type="email" name="mail_id" value="<%= customer.getMailId() %>" required>

            <label>Phone Number:</label>
            <input type="text" name="phone_number" value="<%= customer.getPhoneNumber() %>" required>

            <label>Address:</label>
            <input type="text" name="address" value="<%= customer.getAddress() %>" required>

            <label>NIC Number:</label>
            <input type="text" name="nic_number" value="<%= customer.getNicNumber() %>" required>

            <button type="submit">Update Details</button>
        </form>
    </div>
</body>
</html>
