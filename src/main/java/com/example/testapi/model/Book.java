package com.example.testapi.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;


@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted is null")
public class Book extends BaseEntity{

    private String name;

    private Long price;


}
