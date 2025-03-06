package com.example.student_crud.service;

import com.example.student_crud.model.Student;
import com.example.student_crud.repository.IStudentRepository;
import com.example.student_crud.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyễn Văn A", 20, "a@gmail.com"));
        students.add(new Student(2, "Trần Thị B", 22, "b@gmail.com"));
        students.add(new Student(3, "Lê Văn C", 21, "c@gmail.com"));
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
    public void update(Student student) {
        Student existingStudent = findById(student.getId());
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setEmail(student.getEmail());
        }
    }

    @Override
    public void remove(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public List<Student> search(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (String.valueOf(student.getId()).equals(keyword) || student.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
}
