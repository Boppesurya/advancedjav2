<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
<input type="text" placeholder="Enter our name" name="name">
<br><br> 
<input type="submit">
</form>
<%!
int c=10;
int b= 50;
public int add(){
	return c+b;
}
%>
<%= add() %>
<%
  String n = request.getParameter("name");
%>
<%=
n
%>

</body>
</html>