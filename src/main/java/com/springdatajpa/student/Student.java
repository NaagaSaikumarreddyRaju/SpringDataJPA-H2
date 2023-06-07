package com.springdatajpa.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//this class entity class and with the class name it will create a table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rollNum;
    private String studentName;
    private String schoolName;
    private double avgMarks;

}
