package com.assignment.one.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.one.modal.Assignment;
import com.assignment.one.service.AssignmentService;

@RestController
@RequestMapping
public class AssignmentController {

	@Autowired
	AssignmentService assignmentService;
	
	@PostMapping("/FetchNextNumber")
	public ResponseEntity<?> fetchNextNumber(@RequestBody Assignment assignment) throws InterruptedException {
		
		Map output = new LinkedHashMap();
		if(assignment.getCategoryCode()!=null) {
		 output=  assignmentService.findValue(assignment.getCategoryCode());
		 return new ResponseEntity<Map>(output, HttpStatus.OK);
		}
		
		else
		{
			output.put("message", "category code required for transaction is missing!");
			return  new ResponseEntity<Map>(output, HttpStatus.BAD_REQUEST);
		}
				
	}
}
