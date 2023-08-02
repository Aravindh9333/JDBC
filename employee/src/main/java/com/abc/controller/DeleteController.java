package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abc.dao.*;
;
public class DeleteController extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
	
		DaoInterface dao=new DaoImplementation();
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
 