package com.ellie.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ellie.toy_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");
        String example_Uid = request.getParameter("EXAMPLE_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();

        HashMap<String, Object> question = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HashMap<String, Object> example = null;
        try {
            example = pollWithDB.getExample(example_Uid);
            System.out.println(example.get("EXAMPLE_UID"));
            System.out.println(example.get("EXAMPLE"));
            System.out.println(example.get("ORDERS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        



        // output with html
        request.setAttribute("question", question);
        request.setAttribute("example", example);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);
    }
}
