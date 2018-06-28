package com.redhat.user.service;

import java.util.List;

import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;

public interface ProfileService{

    List<Student> getStudents();

    List<Tutor> getTutors();

    void addStudent(Student student);

    void addAllStudents(List<Student> students);

    void addTutor(Tutor tutor);

    void addAllTutors(List<Tutor> tutors);


}
