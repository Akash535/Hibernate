package com.bean;

public class PartTimeEmp extends Employee{

	int nhrs,hsal;

	
	public PartTimeEmp(int id, String name, int nhrs, int hsal) {
		super(id, name);
		this.nhrs = nhrs;
		this.hsal = hsal;
	}

	public int getNhrs() {
		return nhrs;
	}

	public void setNhrs(int nhrs) {
		this.nhrs = nhrs;
	}

	public int getHsal() {
		return hsal;
	}

	public void setHsal(int hsal) {
		this.hsal = hsal;
	}
	
	
}
