package com.example.testapi.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCard extends BaseEntity{


    private int count;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;
}
