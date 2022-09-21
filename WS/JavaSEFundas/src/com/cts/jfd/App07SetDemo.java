package com.cts.jfd;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.cts.jfd.model.Rect;

public class App07SetDemo {

	public static void main(String[] args) {
		//Set<Rect> rects = new HashSet<Rect>();
		//Set<Rect> rects = new LinkedHashSet<Rect>();
		//Set<Rect> rects = new TreeSet<Rect>();
		
		Comparator<Rect> cmp = new Comparator<Rect>() {

			@Override
			public int compare(Rect o1, Rect o2) {
				//return ((Double)o1.getLength()).compareTo(o2.getLength());
				return ((Double)o1.getBreadth()).compareTo(o2.getBreadth());
			}
			
		};
		
		Set<Rect> rects = new TreeSet<Rect>(cmp);
		
		rects.add(new Rect(10, 10));
		rects.add(new Rect(5, 10));
		rects.add(new Rect(10, 5));
		rects.add(new Rect(4, 10));
		rects.add(new Rect(10, 4));
		rects.add(new Rect(10, 10));
		
		System.out.println(rects.size());
		for(Rect r : rects)
			System.out.println(r);
		
	}

}
