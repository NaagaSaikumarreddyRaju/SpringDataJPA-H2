package com.springdatajpa.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MainApp.class, args);
        PersonRepository repository = context.getBean(PersonRepository.class);

        Person p1 = new Person();
        p1.setFirstName("SaiKumar");
        p1.setLastName("Raju");

        repository.save(p1);
        System.out.println("data saved successfully");

        Person p2 = new Person();
        p2.setFirstName("Sundeep");
        p2.setLastName("Raju");

        Person p3 = new Person();
        p3.setFirstName("Padma");
        p3.setLastName("Reddy");

        repository.saveAll(List.of(p1,p2,p3));

        repository.findAll().forEach(person -> System.out.println(person));

        System.out.println(repository.findById(1L).get());

        System.out.println(repository.existsById(1L));

        repository.findAll().forEach(System.out::println);

        repository.findAllById(List.of(2L,3L)).forEach(System.out::println);
//        repository.findAllById(Arrays.asList(2L,3L)).forEach(System.out::println);

//        System.out.println(repository.count());
//
//        repository.deleteById(1L);
//        repository.delete(p2);
//        repository.deleteAllById(List.of(1L,2L));

    }
}
