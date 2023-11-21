package com.training.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassRoom {

	private Student student;

	@Autowired
	public ClassRoom(Student student) {
		super();
		this.student = student;
	}

	public void displayStudentDetails() {
		System.out.println("Student Details....");
		System.out.println("Student Name:: " + student.getName() + " Age:: " + student.getAge());
	}

}
