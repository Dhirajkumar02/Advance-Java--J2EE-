<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--Directive Tags  -->
    <%@ include file="Hello.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Declarative Tags -->
<%!
	int a = 10;
	String name ="Dhiraj";
	String[] fruits ={"Apple", "Papaya","Orange", "Banana"};
%>

<!-- Expression Tags -->
<h2><%= a %></h2>
<h2><%= name %></h2>

<!--Scriptlet Tags  -->
<% for(String f : fruits){ %>
	<h3><%= f %></h3>
	<% } %>
</body>
</html>