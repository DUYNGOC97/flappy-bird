<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
<center>
    <h1>Student List</h1>
    <h2><a href="student?action=create">Add New Student</a></h2>
</center>
<table border="1" cellpadding="5" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Phone Number</th>
        <th>Classroom</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dateOfBirth}</td>
            <td>${student.address}</td>
            <td>${student.phoneNumber}</td>
            <td>${student.classroomName}</td>
            <td>${student.email}</td>
            <td><a href="student?action=edit&id=${student.id}">Edit</a></td>
            <td><a href="student?action=delete&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>