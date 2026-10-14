package com.example.demo.controllers.user;
import com.example.demo.models.User;
import com.example.demo.services.ReviewManager;
import com.example.demo.services.TutorsManager;
import com.example.demo.services.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UserLogoutServlet", value = "/user-logout")
public class UserLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("logged-in-user");
        response.sendRedirect("index.jsp");
    }
}
