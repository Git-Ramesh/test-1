package com.rs.app1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample5 {
	public static void main(String[] args) {
		// int factor = 2; //Java assumes factor as final when you are using it in
		// stream pipeline
		int[] factor = new int[] { 2 };
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		Stream<Integer> s = numbers.stream().map(num -> num * factor[0]);
		// factor = 3; // Once you made the change it realize non final one so factor in
		// pipeline gives error.
		factor[0] = 0; // ho no you can't make java fool.
		s.forEach(System.out::println);
	}
}
