package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	
	  @Autowired private StudentRepository studentRespository;
	  
		@Override
		public void run(String... args) throws Exception {
			
			
			
			/*
			 * Student student1 = new Student("Nikesh", "Nike", "nikesh@gmail.com");
			 * studentRespository.save(student1);
			 * 
			 * Student student2 = new Student("Naresh", "namra", "naresh@gmail.com");
			 * studentRespository.save(student2);
			 * 
			 * Student student3 = new Student("Ramesh", "Rathod", "ramesh@gmail.com");
			 * studentRespository.save(student3);
			 */
			 
			 

		}
	 
}
