package com.example.testapi.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class ShoppingCard extends BaseEntity{


    private int count;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;
}
