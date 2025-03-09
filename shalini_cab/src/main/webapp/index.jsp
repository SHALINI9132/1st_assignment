<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    
    	<style>
    	
    	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    display: flex;
    align-items: center;
    height: 100vh;
    padding-left: 50px; /* Moves form to the left */
}

form {
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    width: 350px;
}

h2 {
    text-align: left;
    color: #333;
}

label {
    font-weight: bold;
    display: block;
    margin-top: 10px;
}

input, textarea {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

input[type="submit"] {
    background: #28a745;
    color: white;
    border: none;
    padding: 10px;
    cursor: pointer;
    margin-top: 15px;
    width: 100%;
}

input[type="submit"]:hover {
    background: #218838;
}
    	
    	</style>
    	
</head>
<body>

<%
    String message = "";
    
    if (request.getParameter("submit") != null) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mailId = request.getParameter("mail_id");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String nicNumber = request.getParameter("nic_number");

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/project";
        String dbUser = "root"; // Change if needed
        String dbPassword = "123456789"; // Change if needed

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL Insert Query
            String sql = "INSERT INTO Customer (username, password, mail_id, phone_number, address, nic_number) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, mailId);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, address);
            pstmt.setString(6, nicNumber);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                message = "Registration successful!";
            } else {
                message = "Registration failed! Try again.";
            }
        } catch (Exception e) {
            message = "Error: " + e.getMessage();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

<h2>Register</h2>
<form method="post">
    <label>Username:</label> <input type="text" name="username" required><br>
    <label>Password:</label> <input type="password" name="password" required><br>
    <label>Mail ID:</label> <input type="email" name="mail_id" required><br>
    <label>Phone Number:</label> <input type="text" name="phone_number" required><br>
    <label>Address:</label> <textarea name="address" required></textarea><br>
    <label>NIC Number:</label> <input type="text" name="nic_number" required><br>
    <input type="submit" name="submit" value="Register">
</form>

<% if (!message.isEmpty()) { %>
    <p><%= message %></p>
<% } %>

</body>
</html>
