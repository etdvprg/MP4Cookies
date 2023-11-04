<%-- 
    Document   : calculator
    Created on : Nov 1, 2023, 9:59:04 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src = "/MP4Cookies/js/script.js"></script>
        <title>Calculator</title>
    </head>
    <body>
        <h1>The Mighty Paraphernalia of Saint Liborius</h1>
        <form action="/MP4Cookies/calculatorServlet" method="POST">
            Num1: <input type="text" name="Val1" /><select name="history" class="history-dropdown">
                <option selected="selected" disabled="true">History</option>
            </select>
            <br>
               
            Num2: <input type="text" name="Val2" /> <select name="history" class="history-dropdown">
                <option selected="selected" disabled="true">History</option>
            </select>
            <br>

        Operation: 
        <input type="radio" name="operation" value="+" />ADD
        <input type="radio" name="operation" value="-" />SUB
        <input type="radio" name="operation" value="*" />MUL
        <input type="radio" name="operation" value="/" />DIV
        <br>
        <input type="submit" value="Calculate">


        </form>
        
        <%
            Object rizalt = request.getAttribute("result");
            if (rizalt != null) {
                out.println("Result: " + rizalt.toString());
            }
        %>
            
            
    </body>
</html>
