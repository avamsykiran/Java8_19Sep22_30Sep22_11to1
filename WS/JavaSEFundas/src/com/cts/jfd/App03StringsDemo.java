package com.cts.jfd;

import java.util.Scanner;

import com.cts.jfd.model.Rect;

public class App03StringsDemo {

	public static void main(String[] args) {
		Rect r1 = new Rect(10,10);
		System.out.println(System.identityHashCode(r1));
		r1.setLength(100);
		System.out.println(System.identityHashCode(r1));
		
		String s1 = "Hello";
		System.out.println(System.identityHashCode(s1));
		s1 += " World";
		System.out.println(System.identityHashCode(s1));
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = scan.nextLine();
	}

}
