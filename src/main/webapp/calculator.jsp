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
        <link rel="stylesheet" href= "/MP4Cookies/css/calculator.css" />
        <title>Calculator</title>
    </head>
    <body>
        <div class='wrapper'>
        <div class='col-1'>
            <h1>The Mighty Paraphernalia of Saint Liborius</h1>
            <div class="form-holder">
            <form action="/MP4Cookies/calculatorServlet" method="POST">
                <div class="input-holder">
                    Num1: <input type="text" id="text1" name="Val1" /> <select id="drop1" name="history" class="history-dropdown">
                        <option selected="selected" disabled="true">History</option>
                    </select>
                    <br>
                </div>

                <div class="input-holder">
                    Num2: <input type="text" id="text2" name="Val2" /> <select id="drop2" name="history" class="history-dropdown">
                        <option selected="selected" disabled="true">History</option>
                    </select>
                    <br>
                </div>
                
                <div class="input-holder">
                    Operation: 
                    <input type="radio" name="operation" value="+" />ADD
                    <input type="radio" name="operation" value="-" />SUB
                    <input type="radio" name="operation" value="*" />MUL
                    <input type="radio" name="operation" value="/" />DIV
                    <br>
                </div>
                
            <input type="submit" value="Calculate">
<%
                Object rizalt = request.getAttribute("result");
                if (rizalt != null) {
                    out.println("Result: " + rizalt.toString());
                }
            %>

            </form>
            </div>
            
               
        </div>
            
            <div class = 'col-2'>
                Photo of Saint Liborious
            </div>    
        </div>
    </body>
</html>
