package com.example.student_crud.service;

import com.example.student_crud.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    void add(Student student);
    Student findById(int id);
    void update(Student student);
    void remove(int id);
    List<Student> search(String keyword);
}
