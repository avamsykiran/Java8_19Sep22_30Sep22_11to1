package com.cts.jfd.model;

public interface Shape {

	double getArea();
	
	public default double estimatePaintingCost(double paintingRate) {
		return getArea()*paintingRate;
	}
}
