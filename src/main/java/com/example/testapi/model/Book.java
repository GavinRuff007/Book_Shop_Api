package com.example.testapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class Book extends BaseEntity{

    private String name;

    private Long price;


}
