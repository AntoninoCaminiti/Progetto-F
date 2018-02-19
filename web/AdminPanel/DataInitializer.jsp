<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseElements.DatabaseInit" %>


<%
    String host = request.getParameter("host");
    String database = request.getParameter("database");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(!host.equals("") && !database.equals("") && !username.equals("") && !password.equals(""))
    {
        new DatabaseInit().setConn(host, database, username, password);
        response.sendRedirect("../index.html");
    }
    else
    {
        response.sendRedirect("DataInitializer.html");
    }

    


%>