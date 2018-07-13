package com.redhat;

import com.redhat.service.ResultRepository;
import com.redhat.search.search;
import com.redhat.search.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication

public class SearchApplication {

    @AutoWired
    private ResultRepository resultRepo;

    public static void main(String[] args) {

        SpringApplication.run(SearchApplication.class, args);


    }




}