package com.cts.jfd;

import com.cts.jfd.model.Rect;

public class App02ObjectClassSignificance {

	public static void main(String[] args) {
		Rect r1 = new Rect(10, 10);
		Rect r2 = new Rect(10, 10);
		Rect r3 = r1;

		System.out.println(r1 == r2);
		System.out.println(r1 == r3);
		System.out.println(r2 == r3);

		System.out.println(r1.equals(r2));
		System.out.println(r1.equals(r3));
		System.out.println(r2.equals(r3));
	}

}
