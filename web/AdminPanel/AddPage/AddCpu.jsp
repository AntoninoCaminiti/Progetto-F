<%@ page import="Components.CPULoader"%>
<%@ page import="DatabaseElements.*"%>
<%@ page import="Exceptions.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>


<%
    //legge i valori ricevuti dal form HTML
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
        db.filldbCPU(Stringa1, Stringa2, Stringa3, db1, int2, int3, db2);
        out.print("<meta http-equiv=\"refresh\" content=\"0; url=../CompPage/CpuPage.jsp\" />");
    }
    catch(ErrorInsertComponent eic)
    {
        out.println("<font size =\"100\" color=\"red\">" + eic.getMessage() + "</font>");
        out.print("<meta http-equiv=\"refresh\" content=\"3; url=../CompPage/CpuPage.jsp\" />");
        
    }
    catch(SQLException ex){
        out.println("Connessione fallita.");
    }
%>