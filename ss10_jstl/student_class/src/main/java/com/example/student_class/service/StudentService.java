package com.example.student_class.service;

import com.example.student_class.model.Student;
import com.example.student_class.repository.IStudentRepository;
import com.example.student_class.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public Student findById(int id) {
        if (studentRepository.findById(id) != null) {
            return studentRepository.findById(id);
        }
        return null;
    }

    @Override
    public boolean update(int id, Student student) {
        if (studentRepository.update(id, student)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (studentRepository.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Student> searchById(String keyword) {
        return studentRepository.searchById(keyword);
    }
}
