package com.spathesystems.viper.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.spathesystems.viper.dao.entity.Vehicle;
import com.spathesystems.viper.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    @Transactional
    public Vehicle createVehicle(final String type, final String make, final String model, final int year, final String color, final String vin) {
        return this.vehicleService.createVehicle(type, make, model, year, color, vin);
    }
}
