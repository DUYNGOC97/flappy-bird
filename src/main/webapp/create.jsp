<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Student</title>
</head>
<body>
<center>
    <h1>Add New Student</h1>
    <h2>
        <a href="student?action=student">List All Student</a>
    </h2>
</center>
<div align="center">
    <form action="student?action=create" method="post">
        <input type="hidden" name="action" value="create">
        <table border="1" cellpadding="5">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" id="dateOfBirth" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Classroom :</th>
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
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>