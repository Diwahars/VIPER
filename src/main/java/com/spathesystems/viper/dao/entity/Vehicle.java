package com.spathesystems.viper.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.spathesystems.viper.dao.entity.Accident;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@Entity
@Document(collection="Cars")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private int year;

    //@Id
    @Column(name = "vin", nullable = false)
    private String vin;

    @Column(name = "color", nullable = false)
    private String color;

    @OneToMany(
        targetEntity=Accident.class,
        mappedBy="vehicle",
        fetch=FetchType.EAGER)
    private List<Accident> accidents;

    public void addAccident(Accident accident) {
        this.accidents.add(accident);
    }

}
