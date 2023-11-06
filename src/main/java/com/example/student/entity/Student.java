package com.example.student.entity;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private int classRoomId;
    private String classroomName;

    public Student(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int classRoomId, String classroomName) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoomId = classRoomId;
        this.classroomName = classroomName;
    }

    public Student(long id, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int classRoomId, String classroomName) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoomId = classRoomId;
        this.classroomName = classroomName;
    }

    public Student(long id, String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int classRoom) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoomId = classRoom;
    }

    public Student(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email, int classRoom) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoomId = classRoom;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoom) {
        this.classRoomId = classRoom;
    }
}
