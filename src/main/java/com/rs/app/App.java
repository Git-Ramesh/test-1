package com.rs.app;

public class App {
	public static void main(String[] args) {
		int[] elements = { 10, 0, 56, 23, 7, 8, 5 };
		Sample sample = new Sample();
		int min = sample.findMin(elements);
		System.out.println(min);
	}
}

class Sample {
	public int findMin(int[] elements) {
		int min = elements[0];
		for (int i = 1; i < elements.length; i++) {
			if (min > elements[i]) {
				min = elements[i];
			}
		}
		return min;
	}
}