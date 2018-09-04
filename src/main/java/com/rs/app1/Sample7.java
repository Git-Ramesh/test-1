package com.rs.app1;

import java.util.Arrays;
import java.util.List;

import com.rs.app.model.Person;
import com.rs.app.model.Person.Gender;

public class Sample7 {
	public static void main(String[] args) {
		Person p1 = new Person("Ramesh", 23, Gender.MALE);
		Person p2 = new Person("Jaga", 21, Gender.MALE);
		Person p3 = new Person("Harini", 35, Gender.FEMALE);
		Person p4 = new Person("Suma", 40, Gender.FEMALE);
		List<Person> people = Arrays.asList(p1, p2, p3, p4);
		
		System.out.println(people.stream().parallel()
			.filter(person -> person.getGender() == Gender.FEMALE)
			.filter(person -> person.getAge() >30 )
			.map(Person::getName)
			.map(String::toUpperCase)
			.findAny()
			.orElse("No one"));
	}
}
