package com.redhat.user;

import com.redhat.user.reviews.Review;
//import com.redhat.user.service.ReviewsRepository;
import com.redhat.user.app.DGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReviewApplication {

    //@Autowired
    //private ReviewsRepository reviewRepo;

    @Autowired
    private DGService dgService;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }

//    @Bean
//    CommandLineRunner preLoadMongo() throws Exception {
//        return args -> {
//            // Drop the collection if it exists and then add default content
//            reviewRepo.deleteAll();
//            reviewRepo.insert(DEFAULT_REVIEW_LIST);
//        };
//    }

    @Bean
    CommandLineRunner preLoadCache() throws Exception {

        return args -> {

            for (Review r : DEFAULT_REVIEW_LIST){
                //String ui =
                dgService.getReviews().put(r.getReviewId(),r);
            }



        };
    }


    private static List<Review> DEFAULT_REVIEW_LIST = new ArrayList<>();
    static {

        DEFAULT_REVIEW_LIST.add(new Review("1","daniel","First","first review ever","9"));
    }




}
