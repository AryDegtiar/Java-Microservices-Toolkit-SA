package com.sistemasactivos.monitoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data_monitoring")
public class DataMonitoring extends Base {

    private String service;
    private String name;
    private String description;
    private String baseUnit;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Measurement> measurements;
}
