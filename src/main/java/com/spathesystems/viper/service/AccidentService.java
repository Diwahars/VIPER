package com.spathesystems.viper.service;

import com.spathesystems.viper.dao.entity.*;
import com.spathesystems.viper.dao.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public AccidentService(final AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    @Transactional
    public Accident createAccident(final String vin, final String description,final int severity, final String date, final int votes) {
        final Accident accident = new Accident();
        // need to retrieve the vehicle based on the VIN
        //accident.setVehicle(vehicle);
        //VehicleService vehicleService = new VehicleService(new VehicleRepository());
        accident.setVin(vin);
        accident.setDescription(description);
        accident.setSeverity(severity);
        accident.setDate(date);
        accident.setVotes(votes);
        return this.accidentRepository.insert(accident);
    }

    @Transactional(readOnly = true)
    public List<Accident> getAllAccidents() {
        return this.accidentRepository.findAll().stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Accident> getAccidents(final String vin) {
        return this.accidentRepository.findByVin(vin).stream().collect(Collectors.toList());
    }

}