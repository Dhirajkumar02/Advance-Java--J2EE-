<%@page import="com.jsp.spring_mvc.studentdb.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Poppins', sans-serif;
	padding: 20px;
	background: #f4f4f9;
	display: flex;
	flex-direction: column;
	align-items: center;
}

h1 {
	font-size: 2rem;
	color: #333;
	margin-bottom: 20px;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 12px;
	text-align: left;
	border: 1px solid #ddd;
}

th {
	background-color: #007BFF;
	color: white;
}

td {
	background-color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	text-decoration: none;
	padding: 8px 16px;
	border-radius: 5px;
	font-weight: bold;
	margin: 0 5px;
}

.update {
	background-color: #28a745;
	color: white;
}

.delete {
	background-color: #dc3545;
	color: white;
}

.update:hover {
	background-color: #218838;
}

.delete:hover {
	background-color: #c82333;
}

.back-link {
	text-align: center;
	margin-top: 30px;
}

.back-link a {
	font-size: 1.2rem;
	color: #007BFF;
	text-decoration: none;
	font-weight: bold;
}

.back-link a:hover {
	text-decoration: underline;
}

/* Media Query for responsive design */
@media ( max-width : 768px) {
	table {
		overflow-x: auto;
		display: block;
	}
	th, td {
		font-size: 14px;
		padding: 8px;
	}
	h1 {
		font-size: 1.5rem;
	}
}
</style>
</head>
<body>

	<%
	List<Student> sList = (List) request.getAttribute("studentList");
	%>

	<table border="">
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>StudentEmail</th>
			<th>StudentAge</th>
			<th>StudentCourse</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% 
		for(Student s: sList) {
		%>
		<tr>
			<td><%=s.getStudentId()%></td>
			<td><%=s.getStudentName()%></td>
			<td><%=s.getStudentEmail()%></td>
			<td><%=s.getStudentAge()%></td>
			<td><%=s.getStudentCourse()%></td>
			<td><a href="find-by-id?studentId=<%=s.getStudentId()%>"
				class="update">UPDATE</a></td>
			<td><a href="delete-student?studentId=<%=s.getStudentId()%>"
				class="delete">DELETE</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<div class="back-link">
		<h2>
			<a href="index.jsp">Go Back to DashBoard</a>
		</h2>
	</div>
</body>
</html>