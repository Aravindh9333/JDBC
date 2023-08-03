package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.DaoImplementation;
import com.abc.dao.DaoInterface;
import com.abc.model.Employee;

@WebServlet(urlPatterns= {"/view_emp"})
public class EmployeeController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String path=req.getServletPath();
		DaoInterface dao=new DaoImplementation();
		if(path.equals("/view_emp"))
		{
			String fnam=req.getParameter("fname");
			String sname=req.getParameter("sname");
			Employee e=dao.getEmployeeByFnameSname(fnam, sname);
			RequestDispatcher rd=req.getRequestDispatcher("ViewEmployee.jsp");
			req.setAttribute("emp", e);
			rd.include(req, res);
		}
	}
}
