package com.rs.app1;

import java.util.Arrays;
import java.util.List;

public class Sample3 {

	public static int add(int total, int num) {
		int res = total + num;
		System.out.println("add: " + Thread.currentThread());
		return res;
	}
	public static void main(String[] args) throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//Git-Conflict
		//System.out.println(numbers.stream().reduce(0, Sample3::add));
		//System.out.println(numbers.stream().parallel().reduce(0, Sample3::add));
		//System.out.println(numbers.stream().reduce(21, Sample3::add)); //76
		//System.out.println(numbers.stream().parallel().reduce(21, Sample3::add)); //265 wrong
		System.out.println(numbers.stream().parallel().reduce(0, (total, num) -> total+num) + 21); //76
		
		//         1      2
		//	    /       /
		//0 -> op -> op -> .. result
	}
}