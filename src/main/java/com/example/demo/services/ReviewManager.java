package com.example.demo.services;
import com.example.demo.models.Review;
import com.example.demo.utils.FileHandler;
import java.util.ArrayList;

public class ReviewManager {
    private static ArrayList<Review> reviews = null;
    private static final String fileName = "reviews.txt";
    private static int ID = 0;

    public static void readReviews() {
        if (reviews != null)
            return;

        reviews =  new ArrayList<>();

        String[] reviewsDataArr = FileHandler.readFromFile(fileName);
        int reviewId = 0;
        for (String reviewData : reviewsDataArr) {
            String[] reviewDataArr = reviewData.split(",");
            reviewId = Integer.parseInt(reviewDataArr[0]);
            int userId = Integer.parseInt(reviewDataArr[1]);
            int tutorId = Integer.parseInt(reviewDataArr[2]);
            String comment = reviewDataArr[3];
            int rating = Integer.parseInt(reviewDataArr[4]);
            String date = reviewDataArr[5];

            Review review = new Review(reviewId, userId, tutorId, comment, rating, date);
            reviews.add(0, review);
        }
        ID = reviewId;
    }

    public static Review findReview(int id) {
        for (Review review : reviews) {
            if (review.getID() == id) {
                return review;
            }
        }
        return null;
    }

    public static void addReview(int id, int userId, int tutorId, String comment, int rating, String date) {
        Review review = new Review(id, userId, tutorId, comment, rating, date);
        reviews.add(0, review);

        FileHandler.writeToFile(fileName, true, review.toString());
    }

    public static void removeReview(int id) {
        reviews.remove(findReview(id));
        saveReviewsToFile();
    }

    public static void saveReviewsToFile(){
        String reviewsDetails = "";
        for (Review review : reviews) {
            reviewsDetails += review.toString();
        }
        FileHandler.writeToFile(fileName, false, reviewsDetails);
    }

    public static int getNextID() {
        return ++ID;
    }

    public static ArrayList<Review> getReviews() {
        return reviews;
    }

}
