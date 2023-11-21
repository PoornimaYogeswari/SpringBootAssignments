package com.training.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.training.entities.Student;

@Component
public class StudentService implements InitializingBean, DisposableBean {

	private List<Student> studentList = new ArrayList<>();

	public void addStudent(Student s) {
		studentList.add(s);
	}

	public List<Student> getAllStudent() {
		return studentList;
	}

	public Student getStudentById(Long id) {

		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;

	}

	public void updateScore(Long id, int newScore) {

		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				int oldScore = student.getScore();
				student.setScore(newScore);
				System.out.println("Updated score");
				scoreSystem(student, oldScore, newScore);
			}
		}

	}

	public void deleteStudent(Long id) {
		Student rmStudent = null;
		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				rmStudent = student;

			}
		}
		if (rmStudent != null) {
			studentList.remove(rmStudent);
		}
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("<<<<<Initialized StudentService>>>>>");
	}

	public void destroy() throws Exception {
		System.out.println("<<<<<Destroyed StudentService>>>>>>");
	}

	public void scoreSystem(Student student, int oldScore, int newScore) {
		String message;

		if (newScore < 50) {
			message = "Below Average";
		} else if (newScore >= 50 && newScore <= 75) {
			message = "Average";
		} else {
			message = "Above Average";
		}
		System.out.println("Score updated for student ::" + student.getName() + " ID:" + student.getId() + " Old Score="
				+ oldScore + ", New Score=" + newScore + " and the score is " + message);
	}

}
