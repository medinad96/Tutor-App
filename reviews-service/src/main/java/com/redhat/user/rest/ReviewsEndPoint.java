package com.redhat.user.rest;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import com.redhat.user.reviews.Review;
import com.redhat.user.service.ReviewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class ReviewsEndPoint implements Serializable {

    @Autowired
    private ReviewsRepository reviewRepo;

    @ResponseBody
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> listAllReviews() {
        return new ResponseEntity<>(reviewRepo.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/reviews/{id}")
    public ResponseEntity<Void> addReview(@RequestBody Review review) {

        Review newReview = reviewRepo.insert(review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(newReview.getReviewId()).toUri();

        return ResponseEntity.created(location).build();
    }



    @ResponseBody
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") String id) {
        return new ResponseEntity<>(reviewRepo.findByReviewId(id), HttpStatus.OK);
    }

}
