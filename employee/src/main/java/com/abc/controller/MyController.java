package com.abc.controller;

import java.util.List;
import java.util.Scanner;

import com.abc.model.Employee;
import com.abc.dao.*;

public class MyController {
	Scanner s=new Scanner(System.in);
	DaoInterface d=new DaoImplementation();

	
	public void addEmployee()
	{
		Employee emp=new Employee();
		 System.out.println("Enter empid");
		 emp.setEmpid(s.nextInt());
		 System.out.println("Enter employee first name");
		 emp.setFirst_name(s.next());
		 System.out.println("Enter employee sur name");
		 emp.setSurname(s.next());
		 System.out.println("Enter employee gender");
		 emp.setGender(s.next());
		 System.out.println("enter the employee age");
		 emp.setAge(s.nextInt());
		 System.out.println("enter the employee address");
		 emp.setAddress(s.next());
		 System.out.println("enter the employee contact number");
		 emp.setContact_number(s.nextLong());
		 boolean b=d.addEmployee(emp);
		 if(b)
		 {
			 System.out.println("the employee added successfully");
		 }
		 else
		 {
			 System.out.println("the adding of employee is failed");
		 }
		 
	}
	public void deleteStudent()
	{
		System.out.println("enter the employee id to be deleted");
		String fname=s.next();
		String sname=s.next();
		boolean f=d.deleteEmployee(fname,sname);
		if(f)
		{
			System.out.println("deleted succesfully");
		}
	    else
	    {
	    	System.out.println("empid not found");
	    }
	}
	public void updateEmployee()
	{
		System.out.println("enter the employee id to be updated");
		int id=s.nextInt();
		Employee e=new Employee();
		e.setEmpid(id);
		while(true)
		{
			System.out.println("1. updtae first name");
			System.out.println("2. update sur name");
			System.out.println("3.update age");
			System.out.println("4.address");
			System.out.println("5.contact number");
			System.out.println("6.exit");
			int option=s.nextInt();
			if(option==1)
			{
				System.out.println("enter the first name");
				String fname=s.next();
				e.setFirst_name(fname);
			}
			else if(option==2)
			{
				System.out.println("enter the sur name");
				String sname=s.next();
				e.setSurname(sname);
			}
			else if(option==3)
			{
				System.out.println("enter the age");
				int age=s.nextInt();
				e.setAge(age);
				
			}
			else if(option==4)
			{
				System.out.println("enter the address");
				String add=s.next();
				e.setAddress(add);
			}
			else if(option==5)
			{
				System.out.println("enter the contact number");
				Long contact=s.nextLong();
				e.setContact_number(contact);
			}
			else if(option==6)
			{
				System.out.println("thank you");
				break;
			}
		}
		boolean b=d.updateEmployee(e);
		if(b)
		{
			System.out.println("updated");
			
		}
		else
		{
			System.out.println("error");
		}
	}
	public void getEmployeeById()
	{
		System.out.println("enter the employee id");
		int id=s.nextInt();
		Employee e=d.getEmployeeById(id);
		if(e==null)
		{
			System.out.println("no record found");
		}
		else
		{
			System.out.println("empid: "+e.getEmpid());
			System.out.println("firstname: "+e.getFirst_name());
			System.out.println("surname: "+e.getSurname());
			System.out.println("gender: "+e.getGender());
			System.out.println("age: "+e.getAge());
			System.out.println("address: "+e.getAddress());
			System.out.println("cotact_number: "+e.getContact_number());
		}
		
		
	}
	public void viewAllEmployees()
	{
		List<Employee> e1=d.viewAllEmployees();
		for(int i=0;i<e1.size();i++)
		{
			Employee em=e1.get(i);
			System.out.println("empid: "+em.getEmpid());
			System.out.println("firstname: "+em.getFirst_name());
			System.out.println("surname: "+em.getSurname());
			System.out.println("gender: "+em.getGender());
			System.out.println("age: "+em.getAge());
			System.out.println("address: "+em.getAddress());
			System.out.println("cotact_number: "+em.getContact_number());
		}
	}
	
	
	public static void main(String args[])
	{
		MyController mc=new MyController();
	
		while(true)
	    {
	    	System.out.println("1.add employee");
	    	System.out.println("2.delete employee");
	    	System.out.println("3.update employee");
	    	
	    	System.out.println("4.get employee by id");
	    	System.out.println("5.view all employees");
	    	System.out.println("6.exit");
	    	int option=mc.s.nextInt();
	    	if(option==1)
	    	{
	    		mc.addEmployee();
	    	}
	    	else if(option==2)
	    	{
	    		mc.deleteStudent();
	    	}
	    	else if(option==3)
	    	{
	    		mc.updateEmployee();
	    	}
	    	else if(option==4)
	    	{
	    		mc.getEmployeeById();
	    	}
	    	else if(option==5)
	    	{
	    		mc.viewAllEmployees();
	    	}
	    	else
	    	{
	    		System.out.println("THANK YOU");
	    		break;
	    	}
	}
	}	

}
