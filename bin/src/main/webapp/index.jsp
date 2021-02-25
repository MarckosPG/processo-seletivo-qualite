<%@page import="com.qualite.processoseletivo.MySQL_DB"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
        String e = "";
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
            e += ex.getMessage()+", ";
        }
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quests_db", "root", "02051999");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
            e += ex.getMessage();
        }

    %>
<html>
    <head>
        <title>Processo Seletivo</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <%=e%>
        <div class="main">
            <center><div class="section-list"></div></center>
        </div>
    </body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/data.js"></script>
<script src="js/main.js"></script>

<script>
    //incrementado height 'px' dos campos conforme a entrada de dados do usuário
    window.onload = function () {
        const tx = document.getElementsByTagName('textarea');
        for (let i = 0; i < tx.length; i++) {
          tx[i].setAttribute('style', 'height:' + (tx[i].scrollHeight) + 'px;overflow-y:hidden;');
          tx[i].addEventListener("input", OnInput, false);
        }
        function OnInput() {
          this.style.height = 'auto';
          this.style.height = (this.scrollHeight) + 'px';
        }
    }
</script>