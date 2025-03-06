package com.example.student_crud.repository;

import com.example.student_crud.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "John Doe", 20, "john@example.com"));
        students.add(new Student(2, "Jane Smith", 22, "jane@example.com"));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == updatedStudent.getId()) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setEmail(updatedStudent.getEmail());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
