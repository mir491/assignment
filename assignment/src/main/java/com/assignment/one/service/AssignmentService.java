package com.assignment.one.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.one.modal.Assignment;
import com.assignment.one.repository.AssignmentRepository;


@Service
public class AssignmentService {
	
	private Integer oldValue = 0;
	private Integer newValue = 0;
	Map output = null;
	Assignment assignment =null; 

	@Autowired
	AssignmentRepository assignmentRepository;

	public Map  findValue(Integer categoryCode) {
		
		Integer value = 0;
		 assignment = assignmentRepository.findValueByCategoryCode(categoryCode);
		if(assignment != null)
		{
			value = assignment.getValue();
		if(value>0)
			updateValue(value);
		}
		return output;
	}

	private void updateValue(Integer value) {
		
		Integer sumOfDigits=0;
		Integer valueToBeAdded = 0;
		output=new HashMap();
		
		 oldValue=value;
		 output.put("oldValue", value);
		 valueToBeAdded = 10-findSumOfDigits(value);
		 newValue = value+valueToBeAdded;
		 output.put("newValue", newValue);
		 
		 updateDatabase();
	
	}

	private void updateDatabase() {
		// TODO Auto-generated method stub
		Assignment assignmentExisting = assignmentRepository.findById(assignment.getId()).get();
		assignmentExisting.setId(assignment.getId());
		assignmentExisting.setValue(newValue);
		assignmentRepository.save(assignmentExisting);
		
	}

	private Integer findSumOfDigits(Integer value) {
		 Integer sum =0;
		 while(value > 0)
		 {
			 sum = sum+value%10;
			 value = value/10;
		 }
		 
		return sum;
	}

	
}
