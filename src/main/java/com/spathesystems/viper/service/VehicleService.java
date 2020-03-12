package com.spathesystems.viper.service;

import com.spathesystems.viper.dao.entity.Vehicle;
import com.spathesystems.viper.dao.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String make, final String model, final int year, final String color, final String vin) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setYear(year);
        vehicle.setColor(color);
        vehicle.setVin(vin);
        return this.vehicleRepository.insert(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final String vin) {
        return this.vehicleRepository.findByVin(vin);
    }

    @Transactional(readOnly = true)
    public List<String> getModelsForMake(final String make) {
        // first convert to a List
        List<Vehicle> vehicles = this.vehicleRepository.findByMake(make);
        // now need to return the unique models for the specified make
        Set<String> models = new HashSet<String>();

        vehicles.forEach((vehicle) -> {
			models.add(vehicle.getModel());
        });
        // now convert the Set of models to a List for returning
        List<String> m = new ArrayList<String>();
        m.addAll(models);
        return m;
    }

    public List<String> getMakesForType(final String type) {
        List<Vehicle> vehicles = this.vehicleRepository.findByType(type);
        // now need to return the unique models for the specified make
        Set<String> makes = new HashSet<String>();

        vehicles.forEach((vehicle) -> {
			makes.add(vehicle.getMake());
        });
        // now convert the Set of models to a List for returning
        List<String> m = new ArrayList<String>();
        m.addAll(makes);
        return m;
    }

    @Transactional(readOnly = true)
    public List<String> getMakesForYears(final int start, final int end) {
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        Set<String> makes = new HashSet<>();
        vehicles.forEach((vehicle) -> {
            if(start >= vehicle.getYear() && end <= vehicle.getYear()) {
                makes.add(vehicle.getMake());
            }
        });
        List<String> makesList = new ArrayList<>();
        makesList.addAll(makes);
        return makesList;
    }

    @Transactional(readOnly = true)
    public List<String> getTypesForYears(final int start, final int end) {
        List<Vehicle> vehicles = this.vehicleRepository.findAll();
        Set<String> makes = new HashSet<>();
        vehicles.forEach((vehicle) -> {
            if(start >= vehicle.getYear() && end <= vehicle.getYear()) {
                makes.add(vehicle.getType());
            }
        });
        List<String> makesList = new ArrayList<>();
        makesList.addAll(makes);
        return makesList;
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehiclesByMake(final String make) {
        return this.vehicleRepository.findByMake(make);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehiclesByType(final String type) {
        return this.vehicleRepository.findByType(type);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehiclesByYear(final int year) {
        return this.vehicleRepository.findByYear(year);
    }
}
