<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Details</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <% HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question"); %>
      <% ArrayList<String> questions_uid = (ArrayList<String>)request.getAttribute("questions_uid"); %>
      <div class="container">
        <div>
          <!-- Q1 ~ Q5 -->
          <%
            for(int i = 0; i < questions_uid.size(); i++) { 
              String question_a = "<a class='text-secondary text-decoration-none fw-bold' href='/polls/PollServlet?QUESTIONS_UID=";
              String questionUid = questions_uid.get(i);
              question_a += questionUid + "'>" + questionUid + "</a>";
              if(i != questions_uid.size() - 1) {
                question_a += " /";
            }
          %>
          <%= question_a %>
          <% } %>
        </div>
        
        <!-- question -->
        <div class="mt-2 pb-2">
          <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
        </div>

        <!-- answer -->
        <div>
          <%
            ArrayList<HashMap> answer_list = null;
            answer_list = (ArrayList<HashMap>)request.getAttribute("answer_list");
          %>
          <% for(int i = 0; i < answer_list.size(); i++){ %>
            <% HashMap<String, Object> answer = answer_list.get(i); %>
            <div>
              <%
                String answer_input = "<input type='radio' class='form-check-input' name='amswers"
                            + "' id='" + answer.get("EXAMPLE_UID") + "'>";
                String answer_label = "<label class='form-label' for='" + answer.get("EXAMPLE_UID") + "'>("
                            + answer.get("ORDERS") + ") " + answer.get("EXAMPLE") + "</label>";
              %>
              <%= answer_input %>
              <%= answer_label %>
            </div>
          <% } %>
        </div>
      </div>
  </body>
</html>
