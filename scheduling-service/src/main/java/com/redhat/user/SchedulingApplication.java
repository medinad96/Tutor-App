package com.redhat.user;

import com.redhat.user.model.Appointment;
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
public class SchedulingApplication {

    //@Autowired
    //private ReviewsRepository reviewRepo;

    @Autowired
    private DGService dgService;

    public static void main(String[] args) {
        SpringApplication.run(SchedulingApplication.class, args);
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

            for (Appointment r : DEFAULT_APPOINTMENT_LIST){
                //String ui =
                dgService.getAppointments().put(r.getAppointmentId(),r);
            }



        };
    }


    private static List<Appointment> DEFAULT_APPOINTMENT_LIST = new ArrayList<>();
    static {

        DEFAULT_APPOINTMENT_LIST.add(new Appointment("1","Daniel","David","first appointment","12:30pm","07/31/2018","first appointment ever","Approved"));
    }




}