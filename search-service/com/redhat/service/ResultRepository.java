package com.redhat.service;
import org.springframework.data.repository.query.Param;
import com.redhat.search.result;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Result, String>{

    Result findByResult(@Param("results") String result);

}

