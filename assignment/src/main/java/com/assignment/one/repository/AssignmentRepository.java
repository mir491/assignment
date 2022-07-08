package com.assignment.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.one.modal.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

	
	@Query("SELECT NEW Assignment(asign.id, asign.categoryCode, asign.value) FROM Assignment asign WHERE asign.categoryCode =:categoryCode")
	Assignment findValueByCategoryCode(@Param("categoryCode") Integer categoryCode);

}
