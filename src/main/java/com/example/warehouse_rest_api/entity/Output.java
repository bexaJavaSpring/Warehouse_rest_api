package com.example.warehouse_rest_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.random.RandomDataGenerator;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Long facture_number=new RandomDataGenerator().nextLong(1000000000000L, 10000000000000L);;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Client client;
}
