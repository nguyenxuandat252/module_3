package com.example.student_crud.controller;

import com.example.student_crud.model.Student;
import com.example.student_crud.service.IStudentService;
import com.example.student_crud.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    private final IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/view/student/create.jsp").forward(req, resp);
                break;
            case "update":
                showUpdateForm(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "search":
                searchStudent(req, resp);
                break;
            default:
                listStudents(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "update":
                updateStudent(req, resp);
                break;
            default:
                listStudents(req, resp);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        Student student = new Student(studentService.getAll().size() + 1, name, age, email);
        studentService.add(student);
        response.sendRedirect("/students");
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        if (student == null) {
            response.sendRedirect("/students");
        } else {
            request.setAttribute("student", student);
            request.getRequestDispatcher("/view/student/update.jsp").forward(request, response);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        Student student = new Student(id, name, age, email);
        studentService.update(student);
        response.sendRedirect("/students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.remove(id);
        response.sendRedirect("/students");
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Student> students = studentService.search(keyword);
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
    }
}
