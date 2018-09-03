package com.rs.app.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = -3803903985704417370L;
	private int empno;
	private String name;
	private int age;
	private String email;
	private float salary;

	public Employee() {
		super();
	}

	public Employee(int empno, String name, int age, String email, float salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.age = age;
		this.email = email;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", age=" + age + ", email=" + email + ", salary="
				+ salary + "]";
	}

}
