package com.springdatajpa.person;

import jakarta.persistence.*;
import lombok.Data;

@Data // Includes @Getter,@Setter, @toString, default constructor, equals() and hashcode()
@Entity
@Table(name = "person_info")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ssnId;
    @Column(name="fName",length = 20) // we can change the column name of firstName to fName
    private String firstName;
    private String lastName;
}
