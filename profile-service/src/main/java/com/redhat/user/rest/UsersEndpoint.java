package com.redhat.user.rest;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import com.redhat.user.service.StudentRepository;
import com.redhat.user.service.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController("/services")
public class UsersEndpoint implements Serializable {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private TutorRepository tutorRepo;

    @ResponseBody
    @GetMapping("/students")
    public ResponseEntity<List<Student>> listAllStudents() {
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
        return new ResponseEntity<>(studentRepo.findByUserId(id), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/tutors")
    public ResponseEntity<List<Tutor>> listAllTutors() {
        return new ResponseEntity<>(tutorRepo.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/students/{id}")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {

        Student newStudent = studentRepo.insert(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(newStudent.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseBody
    @PostMapping("/tutors/{id}")
    public ResponseEntity<Void> addTutor(@RequestBody Tutor tutor) {

        Tutor newTutor = tutorRepo.insert(tutor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(newTutor.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

}