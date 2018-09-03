package com.rs.app1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample1 {
	public static int transform(Integer num) {
		System.out.println("transform: " + Thread.currentThread());
		return num;
	}
	public static void workWithStream(Stream<Integer> stream) {
		//Convert sequential stream to parallel stream
		stream.parallel().forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		
		//numbers.stream().map(Sample1::transform).forEach(System.out::println);
		//workWithStream(numbers.stream().map(Sample1::transform));
		//numbers.stream().parallel().map(Sample1::transform).forEach(System.out::println);
		//You can convert one stream to another as shown below
		numbers.stream()
			.parallel()
			.sequential() //Converting parallel to sequential stream
			.map(Sample1::transform)
			.forEach(System.out::println);
	}
}