package com.spathesystems.viper.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@Entity
@Document(collection = "Accidents")
public class Accident implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "severity", nullable = false)
    private int severity;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "votes", nullable = false)
    private int Votes;

    @ManyToOne(
        targetEntity=Vehicle.class,
        fetch=FetchType.EAGER)
    private Vehicle vehicle;

    @Column(name = "vin")
    private String vin;
}