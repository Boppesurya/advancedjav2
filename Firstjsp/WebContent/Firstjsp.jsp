<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green;">Welcome to home page</h1>
<%! 
String name="surya"; 
%>
<% out.println("MY Name is:"+name); %>
<%= name %>
</body>
</html>