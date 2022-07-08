package com.assignment.one.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="assignment")

/*
 * lombok not working
 * 
 * @Data
 */
public class Assignment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer categoryCode;
	
	private Integer value;

	
	//getters and setters
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the categoryCode
	 */
	public Integer getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	//toString
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", categoryCode=" + categoryCode + ", value=" + value + "]";
	}
	
	
	//constructors
	
	public Assignment() {
	
	}

	public Assignment(Integer categoryCode, Integer value) {
		super();
		this.categoryCode = categoryCode;
		this.value = value;
	}

	public Assignment(Integer id, Integer categoryCode, Integer value) {
		super();
		this.id = id;
		this.categoryCode = categoryCode;
		this.value = value;
	}
	


	
	
}
