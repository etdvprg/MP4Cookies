/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        
        try {
            double numVal1 = Double.parseDouble(val1);
            double numVal2 = Double.parseDouble (val2);
            
            if (op.equals("+")) {
                result = numVal1 + numVal2;
            } else if (op.equals("-")) {
                result = numVal1 + numVal2;
            } else if (op.equals("*")) {
                result = numVal1 * numVal2;
            } else if (op.equals("/")) {
                result = numVal1 / numVal2;
            }
            
        } catch (ArithmeticException e) {
            throw e;
        } catch (NullPointerException e) { 
            throw e;
        }
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("/Calculator.jsp").forward(request, response);
        
        
  
        
    }


}
