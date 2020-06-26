<%-- 
    Document   : index
    Created on : 25 de jun de 2020, 19:10:04
    Author     : Helmuth
--%>

<%@page import="negocio.Divisao"%>
<%@page import="negocio.Multiplicacao"%>
<%@page import="negocio.Subtracao"%>
<%@page import="negocio.Adicao"%>
<%@page import="negocio.Calculo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora - P2</title>
    </head>
    <body>
        <h3>Helmuth Müller Netto</h3>
        <h3>Análise e Desenvolvimento de Sistemas</h3>
        <h3>Matutino</h3>
        <br>
        
        <h2>Insira os números: </h2>
        <form action="ServletCalculo" method="get">
            Insira o primeiro valor: <input type="text" name="n1"><br>
            Insira o segundo número valor: <input type="text" name="n2"><br>
            <input type='submit' name='btnCalcular' value='soma'>
            <input type='submit' name='btnCalcular' value='subtracao'>
            <input type='submit' name='btnCalcular' value='multiplicacao'>
            <input type='submit' name='btnCalcular' value='divisao'>
        </form>
        <%
            if(request.getParameter("btnCalcular") != null)
            {
                if(request.getParameter("n1").length() > 0 && Float.parseFloat(request.getParameter("n1")) != 0)
                {
                    if(request.getParameter("n2").length() > 0 && Float.parseFloat(request.getParameter("n2")) != 0)
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("ServletCalculo");
                        request.setAttribute("n1", Float.parseFloat(request.getParameter("n1")));
                        request.setAttribute("n2", Float.parseFloat(request.getParameter("n2")));    
                        rd.forward(request, response);
                    }
                    else
                    {
                        out.println("<br><h3>O segundo valor deve ser diferente de 0.</h3>");
                    }
                }
                else
                {
                    out.println("<br><h3>O primeiro valor deve ser diferente de 0.</h3>");
                }
            }
        %>
    </body>
</html>
