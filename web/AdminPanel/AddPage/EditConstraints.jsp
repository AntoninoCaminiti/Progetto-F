<%@ page import="Components.*"%>
<%@ page import="DatabaseElements.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>

<head>
    <meta http-equiv="refresh" content="0; url=../CompPage/ConstraintsPage.jsp" />
</head>

<%
    
    String cpuStatus = request.getParameter("cpustatus");
    String ramStatus = request.getParameter("ramstatus");
    
    try{
        if(cpuStatus.equals("true")) new DBUserHandler().setCPUStatusConstr(true);
        if(cpuStatus.equals("false")) new DBUserHandler().setCPUStatusConstr(false);
        if(ramStatus.equals("true")) new DBUserHandler().setRAMStatusConstr(true);
        if(ramStatus.equals("false")) new DBUserHandler().setRAMStatusConstr(false);
    }
    catch(SQLException e)
    {
        out.println(e.getMessage());
    }
%>