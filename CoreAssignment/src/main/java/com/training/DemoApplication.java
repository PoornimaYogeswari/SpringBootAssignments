package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.StudentService.StudentService;
import com.training.entities.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
		StudentService studentBean = ac.getBean(StudentService.class);
		
		Student s1 = new Student();
		s1.setId(100L);
		s1.setName("Poornima");
		s1.setScore(95);
		 
		Student s2 = new Student();
		s2.setId(101L);
		s2.setName("AnandaKumar");
		s2.setScore(90);
		
		Student s3 = new Student();
		s3.setId(102L);
		s3.setName("Yogeswari");
		s3.setScore(20);
		
		Student s4 = new Student();
		s4.setId(103L);
		s4.setName("Ajay");
		s4.setScore(60);
		
		
		studentBean.addStudent(s1);
		studentBean.addStudent(s2);
		studentBean.addStudent(s3);
		studentBean.addStudent(s4);
		
		System.out.println("All Student List..........");
		studentBean.getAllStudent().forEach(System.out::println);
		
		studentBean.updateScore(103L, 55);
		
		System.out.println("Student List after update..........");
		
		studentBean.getAllStudent().forEach(System.out::println);
		
		System.out.println("Student List after delete..........");
		studentBean.deleteStudent(102L);


		studentBean.getAllStudent().forEach(System.out::println);
	}

}
