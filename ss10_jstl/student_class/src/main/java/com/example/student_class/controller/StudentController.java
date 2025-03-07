package com.example.student_class.controller;

import com.example.student_class.model.Student;
import com.example.student_class.service.IStudentService;
import com.example.student_class.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
            req.getRequestDispatcher("/view/student/create.jsp").forward(req,resp);
            break;
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                Student student = studentService.findById(id);
                req.setAttribute("student", student);
                req.getRequestDispatcher("/view/student/update.jsp").forward(req,resp);
                break;
            default:
                listStudent(req,resp);
                break;
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
                createStudent(req,resp);
                break;
            case "update":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int age = Integer.parseInt(req.getParameter("age"));
                float point = Float.parseFloat(req.getParameter("point"));
                int classId = Integer.parseInt(req.getParameter("classId"));
                Student student = new Student(id, name, age, point, classId);
                studentService.update(id, student);
                resp.sendRedirect("/students");
                break;
            default:
                listStudent(req,resp);
                break;
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/view/student/list.jsp").forward(request, response);
    }
    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        float point = Float.parseFloat(req.getParameter("point"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(studentService.getAll().size(), name, age, point, classId);
        studentService.add(student);
        resp.sendRedirect("/students");
    }

}
