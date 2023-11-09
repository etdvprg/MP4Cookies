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
        
        //input: collection of data from the jsp
        
        String val1 = request.getParameter("Val1");
        String val2 = request.getParameter("Val2");
        String op = request.getParameter("operation");

        double result = 0.0;

        double numVal1;
        double numVal2;

        //process: the condition serves as another "parser", detector, or input sanitator for some potential sneaky characters to bypass the only required information.  
        try {
            if (val1 != null && val1.matches("[-+]?\\d*\\.?\\d+") && val2 != null && val2.matches("[-+]?\\d*\\.?\\d+")) {
                numVal1 = Double.parseDouble(val1);
                numVal2 = Double.parseDouble(val2);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        //process: here lies the process of actually calculating the given values, and extracting the results.
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
        
        //rare cases
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new ArithmeticException();
        }
        
        //formatting of the obtained results, up to two decimal places
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String eResult = decimalFormat.format(result);

        //cookie monster: ArrayList seems to be efficient for data collection in the current regard, especially with its dynamic sizing, iteration, and random access; its T(n) also ranges from O(1) to O(n), depending on the function.
        Cookie[] cookies = request.getCookies();
        List<Cookie> historyCookies = new ArrayList<>();
        
        //cookie monster: replication of the key-value pointers, the use of currentTimeMillis() (thanks Google) provides a unique idenitifier for the cookie.
        String cookieName = "history" + System.currentTimeMillis();
        String cookieValue = eResult;

        Cookie newCookie = new Cookie(cookieName, cookieValue);
        response.addCookie(newCookie);
        
        //cookie monster: critical process of storing the results, and only storing the 5 recent results, the back-end process for the front-end script and jsp. (:O)
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
    }
    
}
