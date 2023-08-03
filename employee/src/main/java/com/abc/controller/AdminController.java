package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.DaoImplementation;
import com.abc.dao.DaoInterface;
import com.abc.model.Employee;

@WebServlet(urlPatterns= {"/add","/delete","/view_all"})
public class AdminController extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String path=req.getServletPath(); // it returns url name
		PrintWriter out=res.getWriter();
		DaoInterface dao=new DaoImplementation();
		
		if(path.equals("/add"))
		{
			Employee em=new Employee();
			em.setFirst_name(req.getParameter("fname"));
			em.setSurname(req.getParameter("sname"));
			em.setAge(Integer.parseInt(req.getParameter("age")));
			em.setGender(req.getParameter("gender"));
			em.setAddress(req.getParameter("address"));
			em.setContact_number(Long.parseLong(req.getParameter("contact")));
			em.setSalary(Double.parseDouble(req.getParameter("salary")));
			boolean b=dao.addEmployee(em);
			if(b)
			{
				out.println("succesfully added");
			}
			else
			{
				out.println("error");
			}
		}
		else if(path.equals("/delete"))
		{
			boolean b=dao.deleteEmployee(req.getParameter("fname"),req.getParameter("sname"));
			if(b)
			{
				out.println("deleted succesfully");
			}
			else
			{
				out.println("something went wrong");
			}
		}
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String path=req.getServletPath(); 
		DaoInterface dao=new DaoImplementation();
		
		if(path.equals("/view_all"))
		{
			ArrayList<Employee> l=dao.viewAllEmployees();
			RequestDispatcher rd=req.getRequestDispatcher("ViewEmployees.jsp");
			req.setAttribute("allemps", l);
			rd.include(req, res);
		}
	}
}
