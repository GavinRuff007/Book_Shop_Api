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
public class User extends BaseEntity{

    private String username;

    private String password;
}
