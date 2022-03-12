package com.example.warehouse_rest_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private long size;
    private String type;

    public Attachment(String name, long size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

}
