package com.training.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

	@Autowired
	private Library library;

	@Autowired
	private ClassRoom classRoom;

	@Override
	public void run(ApplicationArguments arg) throws Exception {
		library.displayBookDetails();
		classRoom.displayStudentDetails();
	}

}
