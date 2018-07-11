package com.redhat.user.service;

import com.redhat.user.profile.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    @Cacheable(value = "student", key = "#p0")
    Student findByUserId(String id);

}
