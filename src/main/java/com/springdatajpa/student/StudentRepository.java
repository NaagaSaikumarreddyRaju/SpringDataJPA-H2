package com.springdatajpa.student;

import com.springdatajpa.student.Student;
import org.springframework.data.repository.CrudRepository;
public interface StudentRepository extends CrudRepository<Student, Long> {
}
