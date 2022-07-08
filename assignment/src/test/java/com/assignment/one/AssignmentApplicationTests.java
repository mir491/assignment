package com.assignment.one;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.one.service.AssignmentService;

@SpringBootTest
class AssignmentApplicationTests {

	
	@Autowired
	AssignmentService service;
	
	@Test
	void contextLoads() throws InterruptedException {
		assertThat(service.findValue(1).equals(19));
	}

}
