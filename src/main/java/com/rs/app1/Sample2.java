package com.rs.app1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample2 {
	public static int transform(Integer num) {
		System.out.println("transform: " + num + "      " + Thread.currentThread());
		return num;
	}

	public static boolean check(int num) {
		System.out.println("check: " + num + "    " + Thread.currentThread());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return true;
	}

	public static void printIt(int num) {
		System.out.println(num + " " + Thread.currentThread());
	}

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// numbers.stream().map(Sample2::transform).forEach(System.out::println);
		// numbers.stream().parallel().map(Sample2::transform).forEach(System.out::println);
		// numbers.stream().parallel().map(Sample2::transform).forEachOrdered(Sample2::printIt);
		//numbers.stream().filter(Sample2::check).forEachOrdered(System.out::println);
		numbers.stream().parallel().filter(Sample2::check).forEachOrdered(System.out::println);
	}
}