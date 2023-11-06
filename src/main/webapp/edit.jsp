<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
</head>
<body>
<center>
    <h1>Edit Student</h1>
    <h2>
        <a href="student?action=student">List All Student</a>
    </h2>
</center>
<div align="center">
    <form action="student?action=edit" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${student.id}">
        <table border="1" cellpadding="5">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" value="${student.name}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" id="dateOfBirth" value="${student.dateOfBirth}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" value="${student.address}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" value="${student.phoneNumber}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Classroom:</th>
                <td>
                    <select name="classRoomId" id="classRoomId">
                        <option value="1" ${student.classRoomId == 1 ? 'selected' : ''}>C02</option>
                        <option value="2" ${student.classRoomId == 2 ? 'selected' : ''}>C03</option>
                    </select>
                </td>>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" value="${student.email}" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>