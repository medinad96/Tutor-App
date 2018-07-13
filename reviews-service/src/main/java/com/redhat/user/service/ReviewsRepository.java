package com.redhat.user.service;
import java.util.List;

import com.redhat.user.reviews.Review;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReviewsRepository extends MongoRepository<Review, String> {

    //List<Review> findAllReviews();

    @Cacheable(value = "review", key = "#p0")
    Review findByReviewId(String id);

}
