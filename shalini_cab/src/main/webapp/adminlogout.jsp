<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // Invalidate session
    HttpSession adminSession = request.getSession(false);
    if (adminSession != null) {
        adminSession.invalidate(); // Destroy session
    }

    // Redirect to admin login page
    response.sendRedirect("adminLogin.jsp");
%>
