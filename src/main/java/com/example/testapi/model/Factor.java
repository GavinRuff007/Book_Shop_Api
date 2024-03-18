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
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Payed payed;

}
