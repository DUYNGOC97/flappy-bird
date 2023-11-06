package com.example.student.controller;

import com.example.student.dao.StudentDao;
import com.example.student.entity.Classroom;
import com.example.student.entity.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showAddStudentForm(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    showEditStudentFrom(request, response);
                    break;
                default:
                    showAllStudent(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertStudent(request, response);
                    break;
                case "edit":
                    editStudent(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public Student(long id, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int classRoom) {

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dateOfBirthString = request.getParameter("dateOfBirth");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date dateOfBirth;
        try {
            dateOfBirth = dateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        LocalDate dateOfBirthLocalDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        String email = request.getParameter("email");
        Student student = new Student(name, dateOfBirthLocalDate, address, phoneNumber, email, classroomId);
        studentDao.insertStudent(student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        request.setAttribute("student", student);
        requestDispatcher.forward(request, response);
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirthString = request.getParameter("dateOfBirth");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date dateOfBirth;
        try {
            dateOfBirth = dateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        LocalDate dateOfBirthLocalDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        int classRoomId = Integer.parseInt(request.getParameter("classRoomId"));
        String email = request.getParameter("email");
        Student student = new Student(id, name, dateOfBirthLocalDate, address, phoneNumber, email, classRoomId);
        studentDao.updateStudentById(student);
        List<Student> studentList = studentDao.selectAllStudent();
        request.setAttribute("studentList", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showAddStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentDao.selectAllStudent();
        List<Student> studentList1 = new ArrayList<>();

        for (Student student : studentList) {
            int id = student.getClassRoomId();
            Classroom classroom = studentDao.selectClassroomById(id);
            student.setClassroomName(classroom.getName());
            Student student1 = new Student(student.getId(), student.getName(), student.getDateOfBirth(), student.getAddress()
                    , student.getPhoneNumber(), student.getEmail(), student.getClassRoomId(), student.getClassroomName());
            studentList1.add(student1);
        }
        request.setAttribute("studentList", studentList1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditStudentFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDao.selectStudentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("student", student);
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDao.deleteStudentById(id);
        List<Student> studentList = studentDao.selectAllStudent();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        request.setAttribute("studentList", studentList);
        dispatcher.forward(request, response);
    }
}
