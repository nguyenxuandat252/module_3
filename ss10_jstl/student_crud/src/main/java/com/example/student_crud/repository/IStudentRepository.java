package com.example.student_crud.repository;

import com.example.student_crud.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();
    void add(Student student);
    Student findById(int id);
    void update(Student student);
    void delete(int id);
}
