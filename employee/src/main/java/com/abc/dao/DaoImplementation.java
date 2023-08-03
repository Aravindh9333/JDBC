package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.model.Employee;

public class DaoImplementation implements DaoInterface {
	Connection con=null;
	public DaoImplementation()
	{
	 try {

         Class.forName("com.mysql.cj.jdbc.Driver");

         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","4457");

     }

     catch(Exception e) {

         System.out.println(e);

     }

 }

	
	public boolean addEmployee(Employee emp) {
		boolean b=false;
		try
		{
		 PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");

	       pstmt.setInt(1, emp.getEmpid());

	       pstmt.setString(2, emp.getFirst_name());

	       pstmt.setString(3, emp.getSurname());

	       pstmt.setString(4, emp.getGender());
	       pstmt.setInt(5, emp.getAge());
	       pstmt.setString(6, emp.getAddress());
	       pstmt.setLong(7, emp.getContact_number());
	       pstmt.setDouble(8, emp.getSalary());

	       int i=pstmt.executeUpdate();

	       if(i>0) {

	           b=true;

	       }

	       }

	       catch(Exception e) {

	           System.out.println(e);

	       }
		
		return b;
	}


	
	public boolean deleteEmployee(String fname, String sname) {
		boolean b=false;
    	try 
    	{
    		PreparedStatement pstmt=con.prepareStatement("delete from employee where first_name=? and surname=?");
    		pstmt.setString(1, fname);
    		pstmt.setString(2, sname);
    		int i=pstmt.executeUpdate();
    		if(i>0)
    		{
    		  b= true;
    		}
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
		
		return b;
	
	}


	
	public Employee getEmployeeByFnameSname(String fname,String sname) {
		Employee em=null;
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employee where first_name=? and surname=?");
			pstmt.setString(1,fname);
			pstmt.setString(2, sname);
			 ResultSet i=pstmt.executeQuery();
			if(i.next())
			{
		    em=new Employee();
			em.setEmpid(i.getInt(1));
			em.setFirst_name(i.getString(2));
			em.setSurname(i.getString(3));
			em.setGender(i.getString(4));
			em.setAge(i.getInt(5));
			em.setAddress(i.getString(6));
			em.setContact_number(i.getLong(7));
			em.setSalary(i.getDouble(8));
			}
			
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		return em;
	}


	
	public ArrayList<Employee> viewAllEmployees() {
		ArrayList<Employee> e1=new ArrayList<>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from Employee");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Employee em=new Employee();
				em.setEmpid(rs.getInt(1));
				em.setFirst_name(rs.getString(2));
				em.setSurname(rs.getString(3));
				em.setGender(rs.getString(4));
				em.setAge(rs.getInt(5));
				em.setAddress(rs.getString(6));
				em.setContact_number(rs.getLong(7));
				em.setSalary(rs.getDouble(8));
				e1.add(em);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return e1;
	}


	
	public boolean updateEmployee(Employee emp) {
		boolean b=false;
		Employee e=getEmployeeByFnameSname(emp.getFirst_name(),emp.getSurname());
		if(emp.getFirst_name()!=null)
			e.setFirst_name(emp.getFirst_name());
		if(emp.getSurname()!=null)
			e.setSurname(emp.getSurname());
		if(emp.getAddress()!=null)
			e.setAddress(emp.getAddress());
		if(emp.getAge()!=0)
			e.setAge(emp.getAge());
		if(emp.getContact_number()!=0)
			e.setContact_number(emp.getContact_number());
		if(emp.getSalary()!=0)
			e.setSalary(emp.getSalary());
		try {
			PreparedStatement pstmt=con.prepareStatement("update employee set first_name=?,surname=?,gender=?,age=?,address=?,contact_number=?,salary=? where emp_id=?");
			pstmt.setInt(8, e.getEmpid());

		       pstmt.setString(1, e.getFirst_name());

		       pstmt.setString(2, e.getSurname());

		       pstmt.setString(3, e.getGender());
		       pstmt.setInt(4, e.getAge());
		       pstmt.setString(5, e.getAddress());
		       pstmt.setLong(6, e.getContact_number());
		       pstmt.setDouble(7, e.getSalary());
		       int i=pstmt.executeUpdate();
		       if(i>0)
		    	   b=true;
		 
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		return b;
	}

}

