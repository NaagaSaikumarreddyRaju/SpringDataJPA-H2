package com.jpacustommethods;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional // To do the delete operations use this annotation
public class BootRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void run(String... args) throws Exception {

        Employee e1 = new Employee();
        e1.setFirstName("sai");
        e1.setLastName("raj");
        e1.setGender("male");
        e1.setEmail("sai@sai.com");

        Employee e2 = new Employee();
        e2.setFirstName("sundeep");
        e2.setLastName("raju");
        e2.setGender("male");
        e2.setEmail("sundeep@sai.com");

        Employee e3 = new Employee();
        e3.setFirstName("padm");
        e3.setLastName("mesala");
        e3.setGender("female");
        e3.setEmail("padma@sai.com");

        Employee e4 = new Employee();
        e4.setFirstName("subba");
        e4.setLastName("reddy");
        e4.setGender("male");
        e4.setEmail("subba@subba.com");

        employeeRepo.saveAll(List.of(e1,e2,e3,e4));

        //Find data based on firstname
        Employee emp = employeeRepo.findByFirstName("sai");
        System.out.println(emp);

        Employee emp2 = employeeRepo.findByLastName("raju");
        System.out.println(emp2);

        Employee emp3 = employeeRepo.findByFirstNameAndLastName("padma","mesala");
        System.out.println(emp3);

        Employee emp4 = employeeRepo.findByFirstNameOrLastName("padma","xyz");
        System.out.println(emp4);

        List<Employee> emp5 = employeeRepo.findByFirstNameStartingWith("s");
        emp5.forEach(n-> System.out.println(n));

        List<Employee> emp6 =employeeRepo.findByLastNameEndingWith("a");
        emp6.forEach(System.out::println);

       long count = employeeRepo.deleteByFirstName("sai");
       System.out.println("Record deleted successfully..."+count);
    }
}
