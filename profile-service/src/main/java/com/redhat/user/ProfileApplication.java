package com.redhat.user;

import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import com.redhat.user.service.StudentRepository;
import com.redhat.user.service.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ProfileApplication {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private TutorRepository tutorRepo;


    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class, args);
    }

    @Bean
    CommandLineRunner preLoadMongo() throws Exception {
        return args -> {
            // Drop the collection if it exists and then add default content
            studentRepo.deleteAll();
            tutorRepo.deleteAll();
            studentRepo.insert(DEFAULT_STUDENT_LIST);
            tutorRepo.insert(DEFAULT_TUTOR_LIST);

        };


    }

    private static List<Student> DEFAULT_STUDENT_LIST = new ArrayList<>();
    static {

        DEFAULT_STUDENT_LIST.add(new Student("1","Daniel","Medina","1234567","dmedina@email.com","first student in list", "boston university","computer science, math"));
    }

    private static List<Tutor> DEFAULT_TUTOR_LIST = new ArrayList<>();
    static {

        DEFAULT_TUTOR_LIST.add(new Tutor("2","Daniel","Med","2345678","dmedina@email.com","first student in list", "boston university","computer science, math, history"));
    }

}