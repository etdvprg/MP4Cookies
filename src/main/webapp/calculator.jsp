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
        <title>Calculator</title>
    </head>
    <body>
        <h1>The Mighty Paraphernalia of Saint Liborius</h1>
        <form action="" method="POST">
            Num1: <input type="string" name="Val1" /><br>
            Num2: <input type="string" name="Val2" /><br>
            Op: <input type="radio" name="addVal" value="+" />ADD
            <input type="radio" name="subVal" value="-" />SUB
            <input type="radio" name="mulVal" value="*" />MUL
            <input type="radio" name="divVal" value="/" />DIV
            <input type="submit">
            
            History : <select name="history" >
                <option selected="selected" disabled="true"> History </option>
                <% 
                    Cookie cookies[] = request.getCookies(); 
                    int j = 0;
                    for(int i = 0; i < cookies.length; i++){  
                        if(cookies[i].getName().equals("history" + j)) {
                %>
                <option value=<%= cookies[i].getValue() %>> <%= cookies[i].getValue()%></option>
                <%          j++;
                        }
                    }
                %>
            </select>
            <br>

        </form>
        
        <%
            Object rizalt = request.getParameter("result");
            if (rizalt != null) {
                out.println(rizalt.toString());
            }
            %>
            
            
    </body>
</html>
