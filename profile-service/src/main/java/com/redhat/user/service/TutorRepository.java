package com.redhat.user.service;

import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TutorRepository extends MongoRepository<Tutor, String> {

    public Tutor findByFirstName(String firstName);
    public List<Tutor> findByLastName(String lastName);

}
