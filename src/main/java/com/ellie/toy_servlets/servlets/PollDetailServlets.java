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
public class PollDetailServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        ArrayList<HashMap> answer_list = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
            answer_list = pollWithDB.getAnswer(questions_Uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < answer_list.size(); i++){
            HashMap<String, Object> answer = answer_list.get(i);
            System.out.println(answer.get("ORDERS"));
            System.out.println(answer.get("EXAMPLE"));
        }

        for(int i = 0; i < answer_list.size(); i++){
            HashMap<String, Object> answer = answer_list.get(i);
            String answer_input = "<input type='radio' class='form-check-input' name='amswers"
                        + "' id='" + answer.get("EXAMPLE_UID") + "'>";
            String answer_label = "<label for='" + answer.get("EXAMPLE_UID") + "'>("
                        + answer.get("ORDERS") + ") " + answer.get("EXAMPLE") + "</label>";
            System.out.println(answer_input);
            System.out.println(answer_label);
        }

        ArrayList<String> questions_uid = null;
        try {
            questions_uid = pollWithDB.getQuestionUid();
            System.out.println(questions_uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < questions_uid.size(); i++) {
            System.out.println(questions_uid.get(i));
        }

        
        for(int i = 0; i < questions_uid.size(); i++) {
            String question_a = "<a href='/polls/PollServlet?QUESTIONS_UID=";
            String questionUid = questions_uid.get(i);
            question_a += questionUid + "'>" + questionUid + "</a>";
            if(i != questions_uid.size() - 1) {
                question_a += " /";
            }
            System.out.println(question_a);
        }



        // output with html
        request.setAttribute("question", question);
        request.setAttribute("questions_uid", questions_uid);
        request.setAttribute("answer_list", answer_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);
    }
}
