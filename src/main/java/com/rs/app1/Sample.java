package com.rs.app1;

import java.util.Arrays;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		int result = 0;
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		for (int num : numbers) {
			if (num % 2 == 0) {
				result += num * 2;
			}
		}
		System.out.println(result);
		//Sterams are lazy
		// Collection Pipeline pattern
		//Sequential code
		System.out.println(numbers.stream().filter(num -> num % 2 == 0).mapToInt(num -> num * 2).sum());
		//The structure of concurrent code is similar to structure of sequential code
		//Concurrent code
		System.out.println(numbers.stream().parallel().filter(num -> num % 2 == 0).mapToInt(num -> num * 2).sum());
	}
}
