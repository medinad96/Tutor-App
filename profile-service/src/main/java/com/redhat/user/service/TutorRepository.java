package com.redhat.user.service;


import com.redhat.user.profile.Tutor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TutorRepository{ //extends MongoRepository<Tutor, String> {

    //Tutor findByFirstName(String firstName);
    //List<Tutor> findByLastName(String lastName);

//    @Cacheable(value = "tutor", key = "#p0")
//    Tutor findByUserId(String id);
//    @CacheEvict(value = "tutor", key = "#p0")
//    void deleteByUserId(String userId);
}
