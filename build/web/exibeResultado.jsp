<%-- 
    Document   : exibeResultado
    Created on : 25 de jun de 2020, 20:26:13
    Author     : Helmuth
--%>

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
        
        <h4><%=request.getAttribute("resultado")%></h4>
    </body>
</html>
