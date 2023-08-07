package com.abc.HibernateDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emp {
	@Id
	int id;
	int age;
	String name;
	double contact_number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getContact_number() {
		return contact_number;
	}
	public void setContact_number(double contact_number) {
		this.contact_number = contact_number;
	}
	
}
