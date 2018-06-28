package com.redhat.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.redhat.user.profile.Student;
import com.redhat.user.profile.Tutor;
import org.bson.Document;

@ApplicationScoped
public class MongoProfileService implements ProfileService {

    @Inject
    private MongoClient mc;

    @Inject
    Logger log;

    private MongoCollection<Document> tutorCollection;

    private MongoCollection<Document> studentCollection;



    public MongoProfileService{

    }


    public List<Product> getStudents() {
        return StreamSupport.stream(productCollection.find().spliterator(), false)
                .map(d -> toStudent(d))
                .collect(Collectors.toList());

    }

    public List<Product> getTutors() {
        return StreamSupport.stream(productCollection.find().spliterator(), false)
                .map(d -> toTutors(d))
                .collect(Collectors.toList());

    }

    public void addStudent(Student student) {
        studentCollection.insertOne(toDocument(student));
    }

    public void addTutor(Tutor tutor) {
        tutorCollection.insertOne(toDocument(tutor));
    }

    public void addAllStudents(List<Student> students) {
        List<Document> documents = products.stream().map(p -> toDocument(p)).collect(Collectors.toList());
        productCollection.insertMany(documents);
    }

    public void addAllTutors(List<Tutors> tutors) {
        List<Document> documents = products.stream().map(p -> toDocument(p)).collect(Collectors.toList());
        productCollection.insertMany(documents);
    }

    @PostConstruct
    protected void init() {
        log.info("@PostConstruct is called...");

        String dbName = System.getenv("DB_NAME");
        if(dbName==null || dbName.isEmpty()) {
            log.info("Could not get environment variable DB_NAME using the default value of 'CatalogDB'");
            dbName = "CatalogDB";
        }

        MongoDatabase db = mc.getDatabase(dbName);


        studentCollection = db.getCollection("students");
        tutorCollection = db.getCollection("tutors");

        // Drop the collection if it exists and then add default content
        productCollection.drop();
        addAll(DEFAULT_PRODUCT_LIST);

    }

    @PreDestroy
    protected void destroy() {
        log.info("Closing MongoClient connection");
        if(mc!=null) {
            mc.close();
        }
    }

    private Document studentToDocument(Student student) {
        return new Document()
                .append("userId",student.getUserId())
                .append("userType",student.getUserType())
                .append("firstName",student.getFirstName())
                .append("lastName",student.getFirstName())
                .append("phoneNumber",student.getPhoneNumber())
                .append("email",student.getEmail())
                .append("description",student.getDescription())
                .append("placeToMeet",student.getPlaceToMeet())
                .append("classhelp",student.getClassHelp());
    }

    private Document tutorToDocument(Student student) {
        return new Document()
                .append("userId",tutor.getUserId())
                .append("userType",tutor.getUserType())
                .append("firstName",tutor.getFirstName())
                .append("lastName",tutor.getFirstName())
                .append("phoneNumber",tutor.getPhoneNumber())
                .append("email",tutor.getEmail())
                .append("description",tutor.getDescription())
                .append("placeToMeet",tutor.getPlaceToMeet())
                .append("classesTohelp",tutor.getClassHelp());
    }

    private Student toStudent(Document document) {
        Student student =  new Student();
        student.setUserId(document.getString("userId"));
        student.setUserType(document.getString("userType"));
        student.setFirstName(document.getString("firstName"));
        student.setLastName(document.getString("lastName"));
        student.setPhoneNumber(document.getString("phoneNumber"));
        student.setEmail(document.getString("email"));
        student.setDescription(document.getString("description"));
        student.setPlaceToMeet(document.getString("placeToMeet"));
        student.setClassHelp(document.getString("classHelp"));
        return student;
    }

    private Tutor toTutor(Document document) {
        Tutor tutor =  new Student();
        tutor.setUserId(document.getString("userId"));
        tutor.setUserType(document.getString("userType"));
        tutor.setFirstName(document.getString("firstName"));
        tutor.setLastName(document.getString("lastName"));
        tutor.setPhoneNumber(document.getString("phoneNumber"));
        tutor.setEmail(document.getString("email"));
        tutor.setDescription(document.getString("description"));
        tutor.setPlaceToMeet(document.getString("placeToMeet"));
        tutor.setClassesToHelp(document.getString("classHelp"));
        return tutor;
    }

    private static List<Student> DEFAULT_STUDENT_LIST = new ArrayList<>();
    static {

        DEFAULT_STUDENT_LIST.add(new Student("111111","Student","Daniel","Medina","1234567","dmedina@email.com","first student in list", "boston university","computer science, math"))
    }

    private static List<Tutor> DEFAULT_TUTOR_LIST = new ArrayList<>();
    static {

        DEFAULT_TUTOR_LIST.add(new Tutor("111112","Tutor","Daniel","Med","2345678","dmedina@email.com","first student in list", "boston university","computer science, math, history"))
    }










}
