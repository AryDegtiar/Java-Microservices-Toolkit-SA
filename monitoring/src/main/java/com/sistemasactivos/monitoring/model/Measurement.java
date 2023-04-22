package com.sistemasactivos.monitoring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "measurement")
public class Measurement extends Base {

    private String statistic;
    private String value;
    private Date date;
}
