package com.example.demo.Repositories;

import com.example.demo.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {

}