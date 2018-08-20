package com.redhat.user.rest;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.Search;
import org.infinispan.query.dsl.FilterConditionContext;
import org.infinispan.query.dsl.QueryBuilder;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.dsl.Query;

import com.redhat.user.app.DGService;
import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import com.redhat.user.profile.Srch;
//import com.redhat.user.service.StudentRepository;
//import com.redhat.user.service.TutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class UsersEndpoint implements Serializable {

//    @Autowired
//    private StudentRepository studentRepo;
//    @Autowired
//    private TutorRepository tutorRepo;

    @Autowired
    private DGService dgService;

    @ResponseBody
    @GetMapping("/students")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Student>> listAllStudents() {

        Map<String, Student> cache = dgService.getStudents();

        return new ResponseEntity<>(cache.keySet().stream()
                .map(cache::get)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
        return new ResponseEntity<>(dgService.getStudents().get(id), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/tutors/{id}")
    public ResponseEntity<Tutor> getTutor(@PathVariable("id") String id) {
        return new ResponseEntity<>(dgService.getTutors().get(id), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/tutors")
    public ResponseEntity<List<Tutor>> listAllTutors() {

        Map<String, Tutor> cache = dgService.getTutors();

        return new ResponseEntity<>(cache.keySet().stream()
                .map(cache::get)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/students/{id}")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {

        //Student newStudent =
        dgService.getStudents().put(student.getUserId(),student); //studentRepo.insert(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(student.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseBody
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") String id) {


        dgService.getStudents().remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @ResponseBody
    @PostMapping("/tutors/{id}")
    public ResponseEntity<Void> addTutor(@RequestBody Tutor tutor) {

        //Tutor newTutor = tutorRepo.insert(tutor);
        dgService.getTutors().put(tutor.getUserId(),tutor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(tutor.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseBody
    @DeleteMapping("/tutors/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable("id") String id) {

        //tutorRepo.deleteByUserId(id);
        dgService.getTutors().remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/tutor-search")
    public ResponseEntity<List<Tutor>> addTutorSearch(@RequestParam(value = "q", defaultValue = "") String keywords) {

        //search query for student repo
        RemoteCache<String, Tutor> cache = dgService.getTutors();
        QueryFactory qf = Search.getQueryFactory(cache);// get the remote cache to be the tutor cache
        QueryBuilder query = qf.from(Tutor.class); // add search methods like .having()
        FilterConditionContext fc = null;

        for (String keyword : keywords.split("\\s+")) {
            if (fc != null) {
                fc = fc.or().having("firstName").like("%" + keyword + "%").or()
                        .having("lastName").like("%" + keyword + "%").or()
                        .having("phoneNumber").like("%" + keyword + "%").or()
                        .having("email").like("%" + keyword + "%").or()
                        .having("description").like("%" + keyword + "%").or()
                        .having("placeToMeet").like("%" + keyword + "%").or()
                        .having("userId").like("%" + keyword + "%").or()
                        .having("classesToHelp").like("%" + keyword + "%");
            } else {
                fc = query.having("firstName").like("%" + keyword + "%").or()
                        .having("lastName").like("%" + keyword + "%").or()
                        .having("phoneNumber").like("%" + keyword + "%").or()
                        .having("email").like("%" + keyword + "%").or()
                        .having("description").like("%" + keyword + "%").or()
                        .having("placeToMeet").like("%" + keyword + "%").or()
                        .having("userId").like("%" + keyword + "%").or()
                        .having("classesToHelp").like("%" + keyword + "%");

            }
        }

        List<Tutor> list = fc.toBuilder().build().list();

        return new ResponseEntity<List<Tutor>>(list, HttpStatus.OK);


    }


    @ResponseBody
    @GetMapping("/student-search")

    public ResponseEntity<List<Student>> addStudentSearch(@RequestParam(value = "q", defaultValue = "") String keywords) {


        //search query for student
        RemoteCache<String, Student> cache = dgService.getStudents();
        QueryFactory qf = Search.getQueryFactory(cache);// get the remote cache to be the student cache
        QueryBuilder query = qf.from(Student.class); // add search methods like .having()

        FilterConditionContext fc = null;

        for (String keyword : keywords.split("\\s+")) {
            if (fc != null) {
                fc = fc.or().having("firstName").like("%" + keyword + "%").or()
                        .having("lastName").like("%" + keyword + "%").or()
                        .having("phoneNumber").like("%" + keyword + "%").or()
                        .having("email").like("%" + keyword + "%").or()
                        .having("description").like("%" + keyword + "%").or()
                        .having("placeToMeet").like("%" + keyword + "%").or()
                        .having("userId").like("%" + keyword + "%").or()
                        .having("classHelp").like("%" + keyword + "%");
            } else {
                fc = query.having("firstName").like("%" + keyword + "%").or()
                        .having("lastName").like("%" + keyword + "%").or()
                        .having("phoneNumber").like("%" + keyword + "%").or()
                        .having("email").like("%" + keyword + "%").or()
                        .having("description").like("%" + keyword + "%").or()
                        .having("placeToMeet").like("%" + keyword + "%").or()
                        .having("userId").like("%" + keyword + "%").or()
                        .having("classHelp").like("%" + keyword + "%");

            }
        }

        List<Student> list = fc.toBuilder().build().list();

        return new ResponseEntity<>(list, HttpStatus.OK);


    }

}
