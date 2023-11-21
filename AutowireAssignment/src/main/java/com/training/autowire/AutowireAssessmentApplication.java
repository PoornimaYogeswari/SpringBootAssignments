package com.training.autowire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.pojo.ApplicationRunnerImpl;
import com.training.pojo.Book;
import com.training.pojo.ClassRoom;
import com.training.pojo.Library;
import com.training.pojo.Student;

@SpringBootApplication
public class AutowireAssessmentApplication {

	@Bean
	public Book getBookBean() {
		return new Book("Novel", "Ponniyin Selvan");
	}

	@Bean
	public Library getLibraryBean() {
		return new Library();
	}

	@Bean
	public Student getStudentBean() {
		return new Student("Poornima", 28);
	}

	@Bean
	public ClassRoom getClassRoomBean() {
		return new ClassRoom(getStudentBean());
	}

	public static void main(String[] args) {
		SpringApplication.run(AutowireAssessmentApplication.class, args);

	}

}
