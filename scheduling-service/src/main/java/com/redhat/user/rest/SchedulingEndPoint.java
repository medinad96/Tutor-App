package com.redhat.user.rest;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import com.redhat.user.app.DGService;
import com.redhat.user.model.Appointment;
//import com.redhat.user.service.ReviewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SchedulingEndPoint implements Serializable {

//    @Autowired
//    private ReviewsRepository reviewRepo;


    @Autowired
    private DGService dgService;

    @ResponseBody
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> listAllAppointments() {
        Map<String, Appointment> cache = dgService.getAppointments();

        return new ResponseEntity<>(cache.keySet().stream()
                .map(cache::get)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/appointments/{id}")
    public ResponseEntity<Void> addAppointments(@RequestBody Appointment appointment) {

        dgService.getAppointments().put(appointment.getAppointmentId(),appointment); //studentRepo.insert(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(appointment.getAppointmentId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseBody
    @PutMapping("/appointments/{id}")
    public ResponseEntity<Void> updateAppointments(@RequestBody Appointment appointment) {

        dgService.getAppointments().replace(appointment.getAppointmentId(),appointment); //studentRepo.insert(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(appointment.getAppointmentId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @ResponseBody
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable("id") String id) {
        return new ResponseEntity<>(dgService.getAppointments().get(id), HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") String id) {

        //tutorRepo.deleteByUserId(id);
        dgService.getAppointments().remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
