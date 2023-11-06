package com.example.student.dao;

import com.example.student.entity.Classroom;
import com.example.student.entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM STUDENT;";
    private static final String SELECT_STUDENT_BY_ID = "select NAME, DATE_OF_BIRTH, ADDRESS,PHONE_NUMBER,EMAIL,CLASSROOM_ID from student where id =?;";
    private static final String INSERT_STUDENT = "INSERT INTO STUDENT (NAME, DATE_OF_BIRTH, ADDRESS,PHONE_NUMBER,EMAIL,CLASSROOM_ID) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE_STUDENT_BY_ID = "update student set NAME = ?,DATE_OF_BIRTH = ?, ADDRESS = ?,PHONE_NUMBER = ?,EMAIL= ?, classroom_id =? where ID = ?;";
    private static final String DELETE_STUDENT_BY_ID = "DELETE FROM STUDENT where ID = ?;";
    private static final String SELECT_CLASSROOM_BY_CLASSROOM_ID = "select NAME from CLASS_ROOM where id =?;";

    public List<Student> selectAllStudent(){
        List<Student> studentList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                int classroom = resultSet.getInt("classroom_id");
                Student student = new Student(id,name,dateOfBirth,address,phoneNumber,email,classroom);
                studentList.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
    public void insertStudent(Student student) {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT);
            statement.setString(1, student.getName());
            LocalDate localDate = student.getDateOfBirth();
            Date date = Date.valueOf(localDate);
            statement.setDate(2, date);
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getPhoneNumber());
            statement.setString(5, student.getEmail());
            statement.setInt(6, student.getClassRoomId());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student selectStudentById(int id){
        Student student = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                int classroom = resultSet.getInt("classroom_id");
                student = new Student(id,name,dateOfBirth,address,phoneNumber,email,classroom);
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
    public Classroom selectClassroomById(int id){
        Classroom classroom = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CLASSROOM_BY_CLASSROOM_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                classroom = new Classroom(id,name);
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return classroom;
    }
    public boolean deleteStudentById(int id) {
        boolean deleteRow = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_BY_ID);
            statement.setInt(1, id);
            deleteRow = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteRow;
    }
    public boolean updateStudentById(Student student) {
        boolean updateRow = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
            statement.setString(1, student.getName());
            LocalDate localDate = student.getDateOfBirth();
            Date date = Date.valueOf(localDate);
            statement.setDate(2, date);
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getPhoneNumber());
            statement.setString(5, student.getEmail());
            statement.setInt(6, student.getClassRoomId());
            statement.setLong(7, student.getId());
            updateRow = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateRow;
    }
}
