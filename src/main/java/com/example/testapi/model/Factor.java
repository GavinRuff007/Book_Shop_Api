package com.example.testapi.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;

}
