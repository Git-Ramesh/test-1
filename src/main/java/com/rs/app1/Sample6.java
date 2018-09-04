package com.rs.app1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Sample6 {
	static int transform(int num) {
		System.out.println("transform: " + num + "      " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
		return num;
	}

	static void processStream(Stream stream) {
		ForkJoinPool pool = new ForkJoinPool(6000);
		pool.submit(() -> {
			stream.forEach(num -> {
			});
		});
		pool.shutdown();
		/*try {
			pool.awaitTermination(25, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		stream.forEach(num -> {
		});
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		Stream<Integer> stream = numbers.stream().parallel().map(Sample6::transform);
		long startTime = System.currentTimeMillis();
		// Streams are lazy until we process to doesn't invoke transform
		processStream(stream);
		long end = System.currentTimeMillis();
		System.out.println("Total time taken: " + (end - startTime) / 1000 + " sec");
	}
}
