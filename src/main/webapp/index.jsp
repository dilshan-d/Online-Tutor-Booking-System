<%@ page import="com.example.demo.services.*" %>

<%--
  Created by IntelliJ IDEA.
  User: Dilshan
  Date: 4/9/2025
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>

<%
    UserManager.readUsers();
    AdminManager.readAdmins();
    PaymentManager.readPayments();
    ReviewManager.readReviews();
    TutorsManager.readTutors();
    BookingManager.readBookings();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/user-login.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
</head>
<body>

<header>
    <div class="header">
        <div>
            <h2 class="header-title">Tutor Booking System</h2>
        </div>
        <div>
            <nav>
                <a class="nav-btn-clicked" href="<%=request.getContextPath()%>/user-login.jsp">User Login</a>
                <a class="nav-btn" href="<%=request.getContextPath()%>/pages/user/register.jsp">User Register</a>
                <a class="nav-btn" href="<%=request.getContextPath()%>/pages/admin/login.jsp">Admin Login</a>
            </nav>

        </div>
    </div>
</header>

<div class="login-container">
    <div class="left-panel">
        <img src="<%= request.getContextPath() %>/images/user-login-page.png" alt="Login Image">
    </div>

    <div class="login-section">
        <div class="login-box">
            <h2>Login to Your Account</h2>
            <form action="user-login" method="post">
                <table>
                    <tbody>
                    <tr>
                        <th>Email</th>
                        <th>:</th>
                        <td><input type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <th>:</th>
                        <td><input type="password" name="password" required></td>
                    </tr>
                    </tbody>
                </table>

                <p class="error-message">
                    <% String error = (String)session.getAttribute("email-password-incorrect");
                        if (error != null ) { %>
                    <%= error %>
                    <% session.removeAttribute("email-password-incorrect"); %>
                    <% } %>
                </p>

                <input class="login-button" type="submit" value="Login"><br>
                <p class="register-msg">Don't have an account? <a href="pages/user/register.jsp">Sign Up</a></p>
            </form>
        </div>
    </div>
</div>

</body>
</html>
