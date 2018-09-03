package com.rs.app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.rs.app.model.Employee;

public class App {
	public static void main(String[] args) {
		int[] elements = { 10, 0, 56, 2, 23, 7, 8, 5, 2 };
		Sample sample = new Sample();
		// int min = sample.findMin(elements);
		// System.out.println(min);
		//sample.findThreeDistinictSmallestElements(elements);
		sample.sortAccordingToHighSal(sample.getEmployees());
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

	public List<Employee> getEmployees() {
		// (int empno, String name, String age, String email, float salary) {
		List<Employee> employees = Arrays.asList(new Employee(101, "Ramesh", 23, "ramesh@gmail.com", 25000.0f),
				new Employee(102, "Kiran", 24, "Kiran@yahoo.com", 35000.0f),
				new Employee(103, "Shela", 30, "sheka@gmail.com", 56000.0f),
				new Employee(104, "Hari", 26, "hari@test.com", 28000.0f));
		return employees;
	}
	public void sortAccordingToHighSal(List<Employee> employees) {
		Comparator<Employee> empComp = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return -((Float)e1.getSalary()).compareTo(e2.getSalary());
			}
		};
 		employees.stream().sorted(empComp).limit(2).map(emp -> emp.getName()).forEach(System.out::println);
	}
	
	
}