<%@ page import="Components.GCardLoader"%>
<%@ page import="DatabaseElements.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>

<head>
    <meta http-equiv="refresh" content="0; url=../CompPage/GCardPage.jsp" />
</head>
<%
    //legge i valori ricevuti dal form HTML
    String Stringa1 = new String (request.getParameter("uAdmin"));
    String Stringa2 = new String (request.getParameter("pAdmin"));
    
    DBUserHandler db = new DBUserHandler();
    
    if(db.addAdmin(Stringa1, Stringa2)==true)
    {
    
    }
    else
    {
        response.sendRedirect("../../ErrorPages/ExistingUserError.jsp");   
    }
%>