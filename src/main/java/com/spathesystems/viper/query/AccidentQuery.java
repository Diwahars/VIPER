package com.spathesystems.viper.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.spathesystems.viper.dao.entity.Accident;
import com.spathesystems.viper.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AccidentQuery implements GraphQLQueryResolver {

    @Autowired
    private AccidentService accidentService;

    public List<Accident> getAccidents(final String vin) {
        return this.accidentService.getAccidents(vin);
    }

}
