package com.abc.dao;

import java.util.ArrayList;
import java.util.List;

import com.abc.model.Employee;

public interface DaoInterface {
	  public boolean addEmployee(Employee emp);

      public boolean deleteEmployee(String fname, String sname);
//
	    public boolean updateEmployee(Employee emp);
//
	    public Employee getEmployeeByFnameSname(String fname,String sname);
//
	    public ArrayList<Employee> viewAllEmployees();


}
