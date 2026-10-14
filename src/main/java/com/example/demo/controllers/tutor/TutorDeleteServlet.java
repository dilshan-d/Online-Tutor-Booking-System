package com.example.demo.controllers.tutor;

import com.example.demo.services.TutorsManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeTutorServlet", value = "/delete-tutor")
public class TutorDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TutorsManager.readTutors();

        int ID = Integer.parseInt(request.getParameter("tutor-id"));

        TutorsManager.removeTutor(ID);

        response.sendRedirect("pages/tutor/admin-view.jsp");
    }
}