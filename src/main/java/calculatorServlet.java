/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.text.DecimalFormat; 
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EnceT
 */
@WebServlet(urlPatterns = {"/calculatorServlet"})
public class calculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ArithmeticException {
        
        String val1 = request.getParameter("Val1");
        String val2 = request.getParameter("Val2");
        String op = request.getParameter("operation");

        double result = 0.0;

        double numVal1;
        double numVal2;

        try {
            numVal1 = Double.parseDouble(val1);
            numVal2 = Double.parseDouble(val2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        try {
            if (op.equals("+")) {
                result = numVal1 + numVal2;
            } else if (op.equals("-")) {
                result = numVal1 - numVal2;
            } else if (op.equals("*")) {
                result = numVal1 * numVal2;
            } else if (op.equals("/")) {
                if (numVal2 == 0.0 || (numVal1 == 0.0 && numVal2 == 0.0)){
                    throw new ArithmeticException();
                } else {
                    result = numVal1 / numVal2;
                }
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String eResult = decimalFormat.format(result);



        Cookie[] cookies = request.getCookies();
        List<Cookie> historyCookies = new ArrayList<>();
        
        String cookieName = "history" + System.currentTimeMillis();
        String cookieValue = eResult;

        Cookie newCookie = new Cookie(cookieName, cookieValue);
        response.addCookie(newCookie);
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("history")) {
                    historyCookies.add(cookie);
                }
            }

            if (historyCookies.size() > 5) {
                historyCookies.subList(0, historyCookies.size() - 5).clear();
                for (Cookie oldCookie : historyCookies.subList(0, historyCookies.size() - 5)) {
                    oldCookie.setMaxAge(0);
                    response.addCookie(oldCookie);
                }
            }
        }
        
        
        request.setAttribute("numVal1", numVal1);
        request.setAttribute("numVal2", numVal2);
        request.setAttribute("ope", op);
        request.setAttribute("result", eResult);
        
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);

        response.setHeader("Cache-Control", "public, max-age=31536000"); // Cache the image for one year

    }


}
