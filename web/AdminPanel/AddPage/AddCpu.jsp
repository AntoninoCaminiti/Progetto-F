<%@ page import="Components.CPULoader"%>
<%@ page import="Components.DBConnection"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>

<head>
    <meta http-equiv="refresh" content="0; url=../CompPage/CpuPage.jsp" />
</head>

<%
    //legge i valori ricevuti dal form HTML
    String str1 = new String (request.getParameter("cod"));
    int int1 = Integer.parseInt(str1);
    String Stringa1 = new String (request.getParameter("brand"));
    String Stringa2 = new String (request.getParameter("model"));
    String Stringa3 = new String (request.getParameter("socket"));
    String Stringa4 = new String (request.getParameter("frequenza_GHZ"));
    Double db1 = Double.parseDouble(Stringa4);
    String Stringa6 = new String (request.getParameter("cores"));
    int int2 = Integer.parseInt(Stringa6);
    String Stringa7 = new String (request.getParameter("tdp"));
    int int3 = Integer.parseInt(Stringa7);
    String Stringa8 = new String (request.getParameter("price"));
    double db2 = Double.parseDouble(Stringa8);

    try{
        DBConnection db = new DBConnection();
        CPULoader cp = new CPULoader();
        db.Connect();
        db.filldbCPU(int1, Stringa1, Stringa2, Stringa3, db1, int2, int3, db2);
    }
    catch(SQLException ex){
        out.println("Connessione fallita.");
    }
%>