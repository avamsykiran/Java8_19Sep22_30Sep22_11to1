package com.cts.jfd.model;

public class Circle implements Shape {

	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI*Math.pow(this.radius, 2);
	}
	
	
}
