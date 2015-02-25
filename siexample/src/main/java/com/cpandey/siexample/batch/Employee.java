package com.cpandey.siexample.batch;

/**
 * @author Chandan Pandey
 *
 */
public class Employee {
	private String name="";
	private String address="";
	private String designation="";
	private String dept="";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Name : "+name+" Address : "+address+" Designation : "+designation+" Department : "+dept;
	}
	
}
