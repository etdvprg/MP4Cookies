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
            <span class="col-1-header">
                The Mighty Paraphernalia of Saint Vincent Ferrer
            </span>
            <div class="form-holder">
            <form action="/MP4Cookies/calculatorServlet" method="POST">
                <div class="input-holder" id="value-input">
                    <input type="text" id="text1" name="Val1" placeholder="First Value" /> <select id="drop1" name="history" class="history-dropdown">
                        <option selected="selected" disabled="true">History</option>
                    </select>
                    <br>
                </div>

                <div class="input-holder" id="value-input">
                    <input type="text" id="text2" name="Val2" placeholder="Second Value" /> <select id="drop2" name="history" class="history-dropdown">
                        <option selected="selected" disabled="true">History</option>
                    </select>
                    <br>
                </div>
                
                <div class="input-holder" id="radio-holder">
                    Operation:
                    <input type="radio" name="operation" value="+" /><label class="lbl">+</label>
                    <input type="radio" name="operation" value="-" /><label class="lbl">–</label>
                    <input type="radio" name="operation" value="*" /><label class="lbl">×</label>
                    <input type="radio" name="operation" value="/" /><label class="lbl">÷</label>
                    <br>
                </div>
                
            <input type="submit" value="Calculate" class="button">
            
            <br>
            <br>
<%
                Object rizalt = request.getAttribute("result");
                Object valA = request.getAttribute("numVal1");
                Object valB = request.getAttribute("numVal2");
                Object ope = request.getAttribute("ope");
                
                if (rizalt != null) {
                    out.println("Result: " +  " " +  valA.toString() + " " + ope.toString() + " " + valB.toString() + " = " + rizalt.toString());
                }
            %>

            </form>
            </div>
            
               
        </div>
            
            <div class = "col-2">
                <div class="img-holder">
                    <img id="img" src="/MP4Cookies/image/ferrer.jpg" alt="St. Vincent Ferrer preaching" loading="lazy">
           
                </div>
                <div class="img-caption">
                    Saint Vincent Ferrer
                </div>
                
            </div>
            
        </div>
    </body>
</html>
