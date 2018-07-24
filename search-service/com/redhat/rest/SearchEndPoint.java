package com.redhat.rest;

import com.redhat.service.ResultRepository;
import com.redhat.search.search;
import com.redhat.search.result;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;


@RestController("/results")
public class SearchEndPoint implements Serializable{

    @Autowired
    private ResultRepository resultRepository;

    @ResponseBody
    @GetMapping("/results")
    public ResponseEntity<List<Result>> listAllResults() {
        return new ResponseEntity<>(resultRepository.findAll(), HttpStatus.OK);
    }

    //Request for a search, reach student and tutor repositories, extract results
    //add results to result repository
    //once a request has been completed, clear the repo

    @ResponseBody
    @PostMapping("/student-search")
    public ResponseEntity<Void> addStudentSearch(@RequestBody Search search) {

        //search query for student repo
        QueryFactory qf = Search.getQueryFactory(remoteCache);// how to get the remote cache to be the student cache?
        Query query = qf.from(Student.class) // add search methods like .having()



    }


    @ResponseBody
    @PostMapping("/tutor-search")
    public ResponseEntity<Void> addStudentSearch(@RequestBody Search search) {

        //search query for tutor repo


    }


//    @ResponseBody
//    @PostMapping("/results")
//    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
//
//        Student newStudent = studentRepo.insert(student);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
//                "/{id}").buildAndExpand(newStudent.getUserId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }

}