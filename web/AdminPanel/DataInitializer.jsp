<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseElements.*" %>
<%@ page import="java.sql.*" %>

<%
    String host = request.getParameter("host");
    String database = request.getParameter("database");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try{
    
        DatabaseInit.getInstance().setConn(host, database, username, password);
        DBConnection test = new DBConnection();
        test.Connect();
        test.closeall();
        response.sendRedirect("../index.html");
    
    }
    catch(SQLException e){
        response.sendRedirect("../ErrorPages/WrongDataInitError.html");
    }

    


%>