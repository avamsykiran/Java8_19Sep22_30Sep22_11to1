package com.cts.jfd;

import java.util.Scanner;

import com.cts.jfd.model.Rect;

public class App04VarArgs {

	public static int sumAll(int... nums) {
		int s = 0;
		for (int n : nums)
			s += n;
		return s;
	}
	
	public static int sumAll2(int[] nums) {
		int s = 0;
		for (int n : nums)
			s += n;
		return s;
	}

	public static void main(String[] args) {
		System.out.println(sumAll());
		System.out.println(sumAll(10));
		System.out.println(sumAll(10,20));
		System.out.println(sumAll(10,20,30,40,50,60,70,80,90));
		
		System.out.println(sumAll2(new int[] {}));
		System.out.println(sumAll2(new int[] {10}));
		System.out.println(sumAll2(new int[] {10,20}));
		System.out.println(sumAll2(new int[] {10,20,30,40,50,60,70,80,90}));
		
	}

}
