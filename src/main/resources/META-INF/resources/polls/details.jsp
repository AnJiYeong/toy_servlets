<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <% HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question"); %>
    <% ArrayList<String> questions_uid = (ArrayList<String>)request.getAttribute("questions_uid"); %>

    <div>
      <%
        for(int i = 0; i < questions_uid.size(); i++) { 
          String question_a = "<a href='/polls/PollServlet?QUESTIONS_UID=";
          String questionUid = questions_uid.get(i);
          question_a += questionUid + "'>" + questionUid + "</a>";
          if(i != questions_uid.size() - 1) {
            question_a += " /";
        }
      %>
      <%= question_a %>
      <% } %>
    </div>

    <div>
      <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
    </div>
    <div>(1) 전혀 아니다 (2) 아니다 (3) 보통이다</div>
  </body>
</html>
