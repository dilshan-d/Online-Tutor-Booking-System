package com.example.demo.controllers.review;
import com.example.demo.services.ReviewManager;
import com.example.demo.services.TutorsManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoveTutorServlet", value = "/remove-tutor")
public class ReviewRemoveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReviewManager.readReviews();

        int reviewID = Integer.parseInt(request.getParameter("reviewID"));

        ReviewManager.removeReview(reviewID);

        response.sendRedirect("pages/review/admin-view.jsp");
    }
}