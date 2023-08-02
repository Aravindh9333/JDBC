package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Employee;
import com.abc.dao.*;

public class AddController extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		
		Employee em=new Employee();
		em.setFirst_name(req.getParameter("fname"));
		em.setSurname(req.getParameter("sname"));
		em.setAge(Integer.parseInt(req.getParameter("age")));
		em.setGender(req.getParameter("gender"));
		em.setAddress(req.getParameter("address"));
		em.setContact_number(Long.parseLong(req.getParameter("contact")));
		em.setSalary(Double.parseDouble(req.getParameter("salary")));
		DaoInterface d=new DaoImplementation();
		boolean b=d.addEmployee(em);
		if(b)
		{
			out.println("succesfully added");
		}
		else
		{
			out.println("error");
		}
		
	}
}
