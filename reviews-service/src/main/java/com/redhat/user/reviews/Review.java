package com.redhat.user.reviews;

public class Review {


    private String reviewId;
    private String reviewTitle;
    private String reviewDescription;
    private String reviewRating;


    public Review(){

    }

    public Review(String reviewId, String reviewTitle, String reviewDescription, String reviewRating) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.reviewRating = reviewRating;
    }


    @Override
    public String toString() {
        return String.format(
                "Tutor[reviewId=%s, reviewTitle='%s' reviewDescription='%s', reviewRating='%s']",
                getReviewId(), getReviewTitle(), getReviewDescription(), getReviewRating());
    }



    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }


}
