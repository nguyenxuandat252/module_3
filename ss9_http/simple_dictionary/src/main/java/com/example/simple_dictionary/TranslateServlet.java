package com.example.simple_dictionary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String search = req.getParameter("txtSearch");
        String result = dictionary.get(search);
        String mess = "";
        if(result!=null){
            mess = "word: "+search+" result:"+result;
        }else {
            mess="not found";
            req.setAttribute("mess",mess);
            req.getRequestDispatcher("/form.jsp").forward(req,resp);
        }
        req.setAttribute("mess",mess);
        req.getRequestDispatcher("/display.jsp").forward(req,resp);
    }
}
