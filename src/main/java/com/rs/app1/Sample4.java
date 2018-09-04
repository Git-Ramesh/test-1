package com.rs.app1;

import java.util.Arrays;
import java.util.List;

public class Sample4 {
	static int x = 1;
	static int y = 3;

	/*
	 * Pure function returns the same result for same input, no matter how many
	 * times call it. Two rules of purity: 1. Function doesn't change anything.. 2.
	 * Then function doesn't depend on anything that is possibly change.
	 */
	public static void main(String[] args) {
		System.out.println(1 + 3); // pure
		// When x, y non final
		System.out.println(x + y); // Impure Rue1 pass but rule 2 failed
		// When x, y final
		System.out.println(x + y); // pure
		// Find the double of first even number grater than 3
		List<Integer> numbers = Arrays.asList(2, 8, 6, 7, 1, 3, 4);
		for (int i = 0; i < numbers.size(); i++) {
			if (isEven(numbers.get(i)) && isGT3(numbers.get(i))) {
				System.out.println(numbers.get(i) * 2);
				break;
			}
		}
		System.out.println(numbers.stream()
			.filter(Sample4::isEven)
			.filter(Sample4::isGT3)
			.map(num -> num *2)
			.findFirst().orElse(0));
	}

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	public static boolean isGT3(int num) {
		return num > 3;
	}

	public static int dbl(int num) {
		return num * 2;
	}
}
