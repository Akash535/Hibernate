package com.bean;

public class FullTimeEmp extends Employee{
	private int fsal,ehrs,ehsal;

	public FullTimeEmp(int id, String name, int fsal, int ehrs, int ehsal) {
		super(id, name);
		this.fsal = fsal;
		this.ehrs = ehrs;
		this.ehsal = ehsal;
	}

	public int getFsal() {
		return fsal;
	}

	public void setFsal(int fsal) {
		this.fsal = fsal;
	}

	public int getEhrs() {
		return ehrs;
	}

	public void setEhrs(int ehrs) {
		this.ehrs = ehrs;
	}

	public int getEhsal() {
		return ehsal;
	}

	public void setEhsal(int ehsal) {
		this.ehsal = ehsal;
	}
	
}
