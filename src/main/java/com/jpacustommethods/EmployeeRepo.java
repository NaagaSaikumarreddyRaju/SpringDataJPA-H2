package com.jpacustommethods;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
    Employee findByFirstName(String firstName);
    Employee findByLastName(String lastName);
    Employee findByFirstNameAndLastName(String firstName,String lastName);
    Employee findByFirstNameOrLastName(String firstName,String lastName);
    List<Employee> findByFirstNameStartingWith(String prefix);
    List<Employee> findByLastNameEndingWith(String suffix);

    long deleteByFirstName(String fName);
    //long deleteByLastName(String fName);
}
