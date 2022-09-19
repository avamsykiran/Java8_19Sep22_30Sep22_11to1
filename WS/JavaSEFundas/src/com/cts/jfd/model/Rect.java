package com.cts.jfd.model;

public class Rect implements Shape{
	
	private double length;
	private double breadth;
	
	public Rect(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	@Override
	public double getArea() {
		return this.length*this.breadth;
	}
	
	
}
