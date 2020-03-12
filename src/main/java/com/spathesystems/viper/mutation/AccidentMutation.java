package com.spathesystems.viper.mutation;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.spathesystems.viper.dao.entity.*;
import com.spathesystems.viper.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccidentMutation implements GraphQLMutationResolver {

    @Autowired
    private AccidentService accidentService;
    @Autowired
    private VehicleService vehicleService;

    public Accident createAccident(final String vin, final String description,final int severity, final String date, final int votes) {
        Accident accident = this.accidentService.createAccident(vin, description, severity, date, votes);
        Optional<Vehicle> vehicle = this.vehicleService.getVehicle(vin);
        if (vehicle.isPresent() == true) {
            accident.setVehicle(vehicle.get());
            vehicle.get().addAccident(accident);
        }
        return accident;
    }
}
