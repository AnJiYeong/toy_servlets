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
    <!-- <% HashMap<String, Object> example = (HashMap<String, Object>)request.getAttribute("example"); %> -->
    <% ArrayList<String> questions_uid = (ArrayList<String>)request.getAttribute("questions_uid"); %>
    <div> 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q1">Q1</a> / 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q2">Q2</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q3">Q3</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q4">Q4</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q5">Q5</a>
    </div>
    <div>
      <a href="/polls/PollServlet?QUESTIONS_UID=Q1"><%= questions_uid.get(0) %></a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q2"><%= questions_uid.get(1) %></a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q3"><%= questions_uid.get(2) %></a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q4"><%= questions_uid.get(3) %></a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q5"><%= questions_uid.get(4) %></a> 
    </div>
    <div>
      <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
    </div>
    <!-- <div>
      (<%= example.get("ORDERS") %>) <%= example.get("EXAMPLE") %> 
    </div> -->
    <div>(1) 전혀 아니다 (2) 아니다 (3) 보통이다</div>
  </body>
</html>
