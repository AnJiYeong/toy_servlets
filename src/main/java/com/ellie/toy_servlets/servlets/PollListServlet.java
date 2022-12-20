package com.ellie.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.ellie.toy_servlets.beans.DatasInfor;
import com.ellie.toy_servlets.beans.MemberBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ServletComponentScan
@SpringBootApplication
@WebServlet(urlPatterns = "/pollListServlet")
public class PollListServlet extends HttpServlet{
    public static void main(String[] args) {
        SpringApplication.run(PollListServlet.class, args);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatasInfor datasInfor = new DatasInfor();
        MemberBean memberBean = datasInfor.getDataWithMemberBean();
        
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("    <meta charset='UTF-8'>");
        printWriter.println("    <title>Tables Bean List Servlets</title>");
        printWriter.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'");
        printWriter.println("        integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'>");
        printWriter.println("    <link rel='stylesheet' href='./css/commons.css'>");
        printWriter.println("</head>");
        
        printWriter.println("<body>");
        printWriter.println("    <div class='container'>");

        

        printWriter.println("    </div>");
        printWriter.println("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("        integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("        crossorigin='anonymous'></script>");
        printWriter.println("</body>");
        printWriter.println("</html>   ");  

        printWriter.close();
    }
}
