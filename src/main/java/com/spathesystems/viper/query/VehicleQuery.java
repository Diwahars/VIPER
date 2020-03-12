package com.spathesystems.viper.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.spathesystems.viper.dao.entity.Vehicle;
import com.spathesystems.viper.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public Optional<Vehicle> getVehicle(final String vin) {
        return this.vehicleService.getVehicle(vin);
    }

    public List<Vehicle> getVehicles() {
        return this.vehicleService.getAllVehicles();
    }

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public List<Vehicle> getVehiclesByMake(final String make) {
        return this.vehicleService.getVehiclesByMake(make);
    }

    public List<Vehicle> getVehiclesByYear(final int year) {
        return this.vehicleService.getVehiclesByYear(year);
    }

    public List<String> getModelsForMake(final String make) {
        return this.vehicleService.getModelsForMake(make);
    }

    public List<String> getMakesForType(final String type) {
        return this.vehicleService.getMakesForType(type);
    }

    //! NOT WORKING
    // public List<String> getMakesForYears(final int start, final int end) {
    //     return this.vehicleService.getMakesForYears(start, end);
    // }

    // public List<String> getTypesForYears(final int start, final int end) {
    //     return this.vehicleService.getTypesForYears(start, end);
    // }

}
