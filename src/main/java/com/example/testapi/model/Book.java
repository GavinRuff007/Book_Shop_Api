package com.example.testapi.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity{

    private String name;

    private Long price;


}
