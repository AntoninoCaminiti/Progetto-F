<%@ page import="Components.*"%>
<%@ page import="DatabaseElements.*"%>
<%@ page import="Exceptions.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>


<%
    //legge i valori ricevuti dal form HTML
    String Stringa1 = new String (request.getParameter("brand"));
    String Stringa2 = new String (request.getParameter("model"));
    String Stringa3 = new String (request.getParameter("type"));
    String Stringa4 = new String (request.getParameter("color"));
    String Stringa5 = new String (request.getParameter("mb_comp"));
    String Stringa6 = new String (request.getParameter("max_hd_len"));
    Double db1 = Double.parseDouble(Stringa6);
    String Stringa7 = new String (request.getParameter("price"));
    double db2 = Double.parseDouble(Stringa7);
    
    try{
        DBComponentController db = new DBComponentController();
        CaseLoader c = new CaseLoader();
        
        db.filldbCase(Stringa1, Stringa2, Stringa3, Stringa4, Stringa5, db1, db2);
        out.print("<meta http-equiv=\"refresh\" content=\"0; url=../CompPage/CasePage.jsp\" />");
        db.closeall();
        
    }
    catch(InsertComponentException eic)
    {
        out.println("<font size =\"100\" color=\"red\">" + eic.getMessage() + "</font>");
        out.print("<meta http-equiv=\"refresh\" content=\"3; url=../CompPage/CasePage.jsp\" />");
        
    }
%>
