package com.example.student_class.repository;

import com.example.student_class.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();
    boolean add(Student student);
    Student findById(int id);
    boolean update(int id,Student student);
    boolean delete(int id);
    List<Student> searchById(String keyword);
}
