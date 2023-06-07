package com.springdatajpa.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepository repository = context.getBean(StudentRepository.class);

		Student s1 = new Student(432,"sai","pact",82);

		//repository.save(student);

		Student s2 = new Student();
		s2.setAvgMarks(120);
		s2.setStudentName("srk");
		s2.setSchoolName("sri sai");

		//repository.save(s1);
		Student s3 = new Student();
		s3.setAvgMarks(67);
		s3.setStudentName("reddy");
		s3.setSchoolName("Sid");

		List<Student> list = List.of(s1,s2,s3);
		repository.saveAll(list);

		System.out.println("Student data inserted successfully.");

		// To fetch the data
		repository.findAll().forEach(student -> System.out.println(student));
		//repository.findAll().forEach(System.out::println); //if we have toString() in the entity class we can go for method reference
	}

}
