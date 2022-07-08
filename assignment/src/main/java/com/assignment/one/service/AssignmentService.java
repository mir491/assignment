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
		
		output = new HashMap();
		Integer value = 0;
		 assignment = assignmentRepository.findValueByCategoryCode(categoryCode);
		if(assignment != null)
		{
			value = assignment.getValue();
		if(value>0)
			updateValue(value);
		else
		{
			output.put("no result", 0);
		}
		}
		else
		{
			output.put("no result", 0);
		}
		
		return output;
	}

	private void updateValue(Integer value) {
		
		output=new HashMap();
		
		 oldValue=value;
		 output.put("oldValue", value);
		 newValue = findSmallestNextNumber(value);
		 output.put("newValue", newValue);
		 if(newValue>oldValue)
		 updateDatabase();
			 
	
	}

	private void updateDatabase() {
		// TODO Auto-generated method stub
		Assignment assignmentExisting = assignmentRepository.findById(assignment.getId()).get();
		assignmentExisting.setId(assignment.getId());
		assignmentExisting.setValue(newValue);
		assignmentRepository.save(assignmentExisting);
		
	}

	private Integer findSmallestNextNumber(Integer value) {
		Integer number = value;
		for(int j = 1; j<10; j++)
		 {
			 value = number + j;
			 System.out.println("value =="+value);
			 if(findSumOfDigits(value)==10 || findSumOfDigits(value)==1)
				 return value;
				 
		 }
		 return 0;
	}

	Integer findSumOfDigits(Integer value)
	{
		Integer sum = 0;
		 while(value > 0)
		 {
			 sum = sum+value%10;
			 value = value/10;
		 }
		 System.out.println("sum is +"+ sum);
		 	return sum;
	}
}
