package com.redhat.user.rest;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import com.redhat.user.app.DGService;
import com.redhat.user.reviews.Review;
//import com.redhat.user.service.ReviewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;
import java.util.stream.Collectors;


public class ReviewsEndPoint implements Serializable {

//    @Autowired
//    private ReviewsRepository reviewRepo;


    @Autowired
    private DGService dgService;

    @ResponseBody
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> listAllReviews() {
        Map<String, Review> cache = dgService.getReviews();

        return new ResponseEntity<>(cache.keySet().stream()
                .map(cache::get)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/reviews/{id}")
    public ResponseEntity<Void> addReview(@RequestBody Review review) {

        dgService.getReviews().put(review.getReviewId(),review); //studentRepo.insert(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(review.getReviewId()).toUri();

        return ResponseEntity.created(location).build();
    }



    @ResponseBody
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") String id) {
        return new ResponseEntity<>(dgService.getReviews().get(id), HttpStatus.OK);
    }

}
