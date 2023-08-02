<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.abc.model.Employee" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Employee> list=(ArrayList<Employee>)request.getAttribute("allemps");
		for(Employee e:list)
		{
			
			out.println("\n"+e.getFirst_name());
			out.println("\n"+e.getSurname());
			out.println("\n"+e.getAge());
			out.println("\n"+e.getGender());
			out.println("\n"+e.getSalary());
			out.println("\n"+e.getAddress());
			out.println("\n"+e.getContact_number());
			out.println("=======================");
		}
	%>
</body>
</html>