package com.redhat.user.reviews;

import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.annotations.ProtoMessage;


@ProtoMessage(name = "AppReview")
public class Review {

    @ProtoField(number = 24)
    public String reviewId;
    @ProtoField(number = 25)
    public String reviewAuthor;
    @ProtoField(number = 26)
    public String reviewTitle;
    @ProtoField(number = 27)
    public String reviewDescription;
    @ProtoField(number = 28)
    public String reviewRating;


    public Review(){

    }

    public Review(String reviewId,String reviewAuthor, String reviewTitle, String reviewDescription, String reviewRating) {
        this.reviewId = reviewId;
        this.reviewAuthor = reviewAuthor;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        this.reviewRating = reviewRating;
    }


    @Override
    public String toString() {
        return String.format(
                "Tutor[reviewId=%s, reviewAuthor=%s, reviewTitle='%s' reviewDescription='%s', reviewRating='%s']",
                getReviewId(), getReviewTitle(), getReviewDescription(), getReviewRating());
    }



    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
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
