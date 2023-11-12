package com.example.springbootproj.model;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface ModelRepository extends MongoRepository<Model, String>{

    
}