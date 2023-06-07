package com.jpacustommethods;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="empinfo")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String firstName;
    private String lastName;
    private String email;
    @Column(name="sex")
    private String gender;
}
