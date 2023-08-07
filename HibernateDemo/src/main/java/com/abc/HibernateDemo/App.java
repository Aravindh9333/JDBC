package com.abc.HibernateDemo;

import java.util.List;
import java.util.Scanner;

import com.abc.HibernateDemo.model.Emp;
import com.abc.HibernateDemo.dao.*;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc=new Scanner(System.in);
	DaoInterface dao=new DaoImplementation();
	
    public static void main( String[] args )
    {
        App a=new App();
        while(true)
        {
        	System.out.println("1. Add Employee");
        	System.out.println("2. Delete Employee");
        	System.out.println("3. Get By Id");
        	System.out.println("4. View All");
        	System.out.println("5. Exit");
        	int option=a.sc.nextInt();
        	if(option==1)
        	{
        		a.addEmployee();
        	}
        	else if(option==2)
        	{
        		a.deleteEmployee();
        	}
        	else if(option==3)
        	{
        		a.viewById();
        	}
        	else if(option==4)
        	{
        		a.viewAll();
        	}
        	else
        	{
        		break;
        	}
        }
        
        
    }
	private void viewAll() {
		List<Emp> l=dao.viewAllEmployee();
		for(Emp e:l)
		{
			System.out.println("Id "+e.getId());
			System.out.println("Name "+e.getName());
			System.out.println("Age "+e.getAge());
			System.out.println("Contact Number "+e.getContact_number());
			
		}
		
	}
	private void viewById() {
		System.out.println("Enter Id To display");
		dao.getEmployeeById(sc.nextInt());
	}
	private void addEmployee() {
		Emp e=new Emp();
		System.out.println("Enter Id");
		e.setId(sc.nextInt());
		System.out.println("Enter Name");
		e.setName(sc.next());
		System.out.println("Enter Age");
		e.setAge(sc.nextInt());
		System.out.println("Enter contact number");
		e.setContact_number(sc.nextDouble());
		
		dao.addEmployee(e);
		
	}
	private void deleteEmployee()
	{
		System.out.println("Enter Id To Delete");
		dao.deleteEmp(sc.nextInt());
	}
	
}
