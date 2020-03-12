package com.spathesystems.viper.dao.repository;

import com.spathesystems.viper.dao.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    public List<Vehicle> findByMake(String make);
    public List<Vehicle> findByType(String type);
    public List<Vehicle> findByYear(int year);
    public Optional<Vehicle> findByVin(String vin);
}
