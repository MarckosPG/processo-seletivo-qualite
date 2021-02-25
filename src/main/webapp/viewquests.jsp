<%@page import="java.util.List"%>
<%@page import="com.qualite.processoseletivo.QuestResponseDAO"%>
<%@page import="com.qualite.processoseletivo.MySQL_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Processo Seletivo</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/table.css">
    </head>
    <body>
        <div class="main">
            <table>
                <caption> <label class="backbutton"><-Voltar </label>&nbsp;&nbsp;Respostas das Questões</caption>
                <thead>
                  <tr>
                    <th scope="col">Usuário</th>
                    <th scope="col">Seção</th>
                    <th scope="col">Questão</th>
                    <th scope="col">Resposta</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                        MySQL_DB mysql = new MySQL_DB();
                        List<QuestResponseDAO> dao = mysql.selectAllQuests();
                        for(int i = 0; i < dao.size(); i++){
                    %>
                  <tr>
                    <td data-label="Usuário">Fulano</td>
                    <td data-label="Seção"><%= dao.get(i).getSection_title()%></td>
                    <td data-label="Questão"><%= dao.get(i).getQuest_title() %></td>
                    <td data-label="Resposta"><%= dao.get(i).getQuest_response() %></td>
                  </tr>
                  <%
                      }
                  %>
                </tbody>
              </table>
        </div>
    </body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(".backbutton").click(function () {
        window.location = "index.jsp";
    });
</script>
