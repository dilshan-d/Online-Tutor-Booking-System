<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin-logic.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
</head>
<body>

<header>
    <div class="header">
        <div>
            <h2 class="header-title">Tutor Booking System</h2>
        </div>
        <div>
            <nav>
                <a class="nav-btn" href="<%=request.getContextPath()%>/index.jsp">User Login</a>
                <a class="nav-btn" href="<%=request.getContextPath()%>/pages/user/register.jsp">User Register</a>
                <a class="nav-btn-clicked" href="<%=request.getContextPath()%>/pages/admin/login.jsp">Admin Login</a>
            </nav>
        </div>
    </div>
</header>

<div class="main-container">
    <div class="left-image">
        <img src="<%=request.getContextPath()%>/images/admin-login-page.png" alt = "admin-login-page">
    </div>
    <div class="login-section">
        <div class="login-box-right">
                <h2>Enter Admin Login Details</h2>
                <form action="<%=request.getContextPath()%>/admin-login" method="post">
                    <table>
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
                    </table>

                    <p class="error-message">
                        <% String error = (String)session.getAttribute("email-password-incorrect");
                            if (error != null ) { %>
                        <%=error%>
                        <%session.removeAttribute("email-password-incorrect");%>
                        <% } %>
                    </p>

                    <input class="login-button" type="submit" value="Login">
                </form>
        </div>
    </div>
</div>

</body>
</html>
