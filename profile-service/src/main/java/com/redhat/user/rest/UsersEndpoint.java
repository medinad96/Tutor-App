package com.redhat.user.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.coolstore.model.Product;
import com.redhat.coolstore.service.CatalogService;

@SessionScoped
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UsersEndpoint implements Serializable {

    @Inject
    private ProfileService profileService;

    @GET
    @Path("/")
    public List<Students> listAllStudents() {
        return profileService.getStudents();
    }

    @GET
    @Path("/")
    public List<Students> listAllTutors() {
        return profileService.getTutors();
    }

    @POST
    @Path("/")
    public Response addStudent(Student student) {
        profileService.addStudent(student);
        return Response.ok().build();
    }

    @POST
    @Path("/")
    public Response addTutor(Tutor tutor) {
        profileService.addTutor(tutor);
        return Response.ok().build();
    }

}