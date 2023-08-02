package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.DaoImplementation;
import com.abc.dao.DaoInterface;
import com.abc.model.Employee;

public class viewEmployee extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out=res.getWriter();
		DaoInterface d=new DaoImplementation();
		ArrayList<Employee> l=d.viewAllEmployees();
		RequestDispatcher rd=req.getRequestDispatcher("ViewEmployee.jsp");
		req.setAttribute("allemps", l);
		rd.include(req, res);
		
	}

}
