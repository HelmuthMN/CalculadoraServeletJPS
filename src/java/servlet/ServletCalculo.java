/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.*;

/**
 *
 * @author alema
 */
@WebServlet(name = "ServletCalculo", urlPatterns = {"/ServletCalculo"})
public class ServletCalculo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            RequestDispatcher rd;
            
            if ((request.getParameter("n1") != null && request.getParameter("n1").length() > 0) &&
                (request.getParameter("n2") != null && request.getParameter("n2").length() > 0))
            {           
                float v1 = Float.parseFloat(request.getParameter("n1"));
                float v2 = Float.parseFloat(request.getParameter("n2"));
                
                if(v2 == 0 && request.getParameter("btnCalcular").equals("divisao"))
                {
                    rd = request.getRequestDispatcher("index.jsp");  
                    rd.include(request, response);
                }
                else{
                    Calculo objCalc = null;

                    switch (request.getParameter("btnCalcular")) {
                        case "soma":
                            {
                                objCalc = new Adicao(v1, v2);
                                Float resultadoSoma = objCalc.calcular();
                                request.setAttribute("resultado", resultadoSoma);
                                break;
                            }
                        case "subtracao":
                            {
                                objCalc = new Subtracao(v1, v2);
                                Float resultadoSubtracao = objCalc.calcular();
                                request.setAttribute("resultado", resultadoSubtracao);
                                break;
                            }
                        case "multiplicacao":
                            {
                                objCalc = new Multiplicacao(v1, v2);
                                Float resultadoMultiplicacao = objCalc.calcular();
                                request.setAttribute("resultado", resultadoMultiplicacao);
                                break;
                            }
                        case "divisao":
                            {
                                objCalc = new Divisao(v1, v2);
                                Float resultadoDivisao = objCalc.calcular();
                                request.setAttribute("resultado", resultadoDivisao);
                                break;
                            }
                        default:
                                break;
                    }
                         rd = request.getRequestDispatcher("exibeResultado.jsp");
                         rd.forward(request, response);
                }
            }
            else{
                rd = request.getRequestDispatcher("index.jsp");  
                rd.include(request, response);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
