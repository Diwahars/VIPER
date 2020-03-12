package com.spathesystems.viper.dao.repository;

import java.util.List;

import com.spathesystems.viper.dao.entity.Accident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccidentRepository extends MongoRepository<Accident, String> {
    public List<Accident> findByVin(String vin);
}
