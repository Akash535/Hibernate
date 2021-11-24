package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	// specifies create table for given class
@Table(name = "Emp_Details")

public class Employee {
	@Id	// map just below listed property as primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//mark pk auto_increment
	@Column(name = "emp_id")// specifies column name for just below listed property
	private int eid;
	
	@Column(name = "emp_name")
	private String name;
	private String designation;
	private float salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
