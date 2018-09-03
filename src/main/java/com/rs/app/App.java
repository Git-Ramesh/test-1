package com.rs.app;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) {
		int[] elements = { 10, 0, 56, 2, 23, 7, 8, 5, 2 };
		Sample sample = new Sample();
		// int min = sample.findMin(elements);
		// System.out.println(min);
		sample.findThreeDistinictSmallestElements(elements);
	}
}

class Sample {
	public int findMin(int[] elements) {
		OptionalInt oi = IntStream.of(elements).parallel().min();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		if (oi.isPresent()) {
			System.out.println(oi.getAsInt());
		}
		System.out.println("Thread: " + Thread.currentThread().getName());
		return oi.getAsInt();
	}

	public void findThreeDistinictSmallestElements(int[] elements) {
		IntStream.of(elements).distinct().sorted().limit(3).boxed().forEach(System.out::println);
	}
}