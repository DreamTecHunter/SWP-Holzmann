<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Object object1 = request.getAttribute("user");
	String user1 =(String)object1;
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello
	<%
			Object object2 = request.getAttribute("user");
			String user2 =(String)object2;
			out.append(user2);
		%>
	</h1>


	<h1>Hello <%=user1 %></h1>
	
	<!-- Tag lib -->
	<h1>Hello ${user},</h1>
	<h2>your password is "${password}"</h2>
</body>
</html>