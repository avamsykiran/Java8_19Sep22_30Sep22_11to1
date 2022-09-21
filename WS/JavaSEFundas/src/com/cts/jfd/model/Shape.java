package com.cts.jfd.model;

public interface Shape extends Comparable<Shape>{

	double getArea();
	
	public default double estimatePaintingCost(double paintingRate) {
		return getArea()*paintingRate;
	}
	
	@Override
	default int compareTo(Shape o) {
		return ((Double)this.getArea()).compareTo(o.getArea());
	}
}
