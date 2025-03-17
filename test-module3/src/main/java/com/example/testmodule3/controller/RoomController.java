package com.example.testmodule3.controller;

import com.example.testmodule3.dto.RoomDto;
import com.example.testmodule3.model.Room;
import com.example.testmodule3.service.IRoomService;
import com.example.testmodule3.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomController", value = "/rooms")
public class RoomController extends HttpServlet {
    private IRoomService roomService = new RoomService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                roomService.delete(id);
                resp.sendRedirect("/rooms");
                break;
            case "add":
                addRoom(req,resp);
                break;
            case "search":
                String code = req.getParameter("search");
                List<RoomDto> roomDtos = roomService.search(code);
                req.setAttribute("roomDtos",roomDtos);
                req.getRequestDispatcher("/view/room/list.jsp").forward(req,resp);
                break;
            default:
                listRoom(req, resp);
                break;
        }
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = studentService.getAll().size();
//        String code = req.getParameter("code");
//        String name = req.getParameter("name");
//        int age = Integer.parseInt(req.getParameter("age"));
//        double score = Double.parseDouble(req.getParameter("score"));
//        int idClass = Integer.parseInt(req.getParameter("idClass"));
//        Student student = new Student(id,code,name,age,score,idClass);
//        studentService.add(student);
//        resp.sendRedirect("/students");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                resp.sendRedirect("/view/room/add.jsp");
                break;
            default:
                listRoom(req,resp);
                break;
        }
    }

    private void listRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoomDto> roomDtos = roomService.getAll();
        req.setAttribute("roomDtos",roomDtos);
        req.getRequestDispatcher("/view/room/list.jsp").forward(req, resp);
    }
    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = roomService.getAll().size();
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String startDate = req.getParameter("startDate");
        int idPay = Integer.parseInt(req.getParameter("idPay"));
        String note = req.getParameter("note");
        Room room = new Room(id,code,name,phone,startDate,idPay,note);
        roomService.add(room);
        resp.sendRedirect("/rooms");
    }
}
