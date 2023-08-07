package com.abc.HibernateDemo.dao;

import java.util.List;

import com.abc.HibernateDemo.model.Emp;

public interface DaoInterface {
	public void addEmployee(Emp e);
	public void deleteEmp(int i);
	List<Emp> viewAllEmployee();
	Emp getEmployeeById(int i);
}
