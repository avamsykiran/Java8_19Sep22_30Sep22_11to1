package com.cts.jfd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cts.jfd.model.Rect;

public class App06ListDemo {

	public static void main(String[] args) {
		List<Rect> rects = new ArrayList<Rect>();
		
		rects.add(new Rect(10, 10));
		rects.add(new Rect(5, 10));
		rects.add(new Rect(10, 5));
		rects.add(new Rect(4, 10));
		rects.add(new Rect(10, 4));
		
		System.out.println(rects.size());
		for(Rect r : rects)
			System.out.println(r);
		
		System.out.println("-------------------------------------------");
		
		Collections.sort(rects);
		for(Rect r : rects)
			System.out.println(r);
		
		System.out.println("-------------------------------------------");
		
		Comparator<Rect> cmp = new Comparator<Rect>() {

			@Override
			public int compare(Rect o1, Rect o2) {
				//return ((Double)o1.getLength()).compareTo(o2.getLength());
				return ((Double)o1.getBreadth()).compareTo(o2.getBreadth());
			}
			
		};
		
		Collections.sort(rects,cmp);
		for(Rect r : rects)
			System.out.println(r);
	
	}

}
