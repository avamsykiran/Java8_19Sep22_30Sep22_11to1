package com.cts.jfd;

import com.cts.jfd.model.Circle;
import com.cts.jfd.model.Rect;

public class App01InterfaceDemo {

	public static void main(String[] args) {
		Rect r1 = new Rect(10, 10);
		Circle c1 = new Circle(10);
		
		System.out.println(r1.estimatePaintingCost(12));
		System.out.println(c1.estimatePaintingCost(12));
	}

}
