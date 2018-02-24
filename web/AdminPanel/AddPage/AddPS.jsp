<%@ page import="Components.PSLoader"%>
<%@ page import="DatabaseElements.*"%>
<%@ page import="Exceptions.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>

<%
    //legge i valori ricevuti dal form HTML
    String Stringa1 = new String (request.getParameter("brand"));
    String Stringa2 = new String (request.getParameter("model"));
    String Stringa3 = new String (request.getParameter("series"));
    String Stringa4 = new String (request.getParameter("form"));
    String Stringa5 = new String (request.getParameter("efficiency"));
    String Stringa6 = new String (request.getParameter("tdp"));
    int Int1 = Integer.parseInt(Stringa6);
    String Stringa7 = new String (request.getParameter("modular"));
    String Stringa8 = new String (request.getParameter("price"));
    double db1 = Double.parseDouble(Stringa8);

    try{
        DBComponentController db = new DBComponentController();
        PSLoader ps = new PSLoader();
        db.Connect();
        db.filldbPS(Stringa1, Stringa2, Stringa3, Stringa4, Stringa5, Int1, Stringa7, db1);
        out.print("<meta http-equiv=\"refresh\" content=\"0; url=../CompPage/PowerSupplyPage.jsp\" />");
    }
    catch(InsertComponentException eic)
    {
        out.println("<font size =\"100\" color=\"red\">" + eic.getMessage() + "</font>");
        out.print("<meta http-equiv=\"refresh\" content=\"3; url=../CompPage/PowerSupplyPage.jsp\" />");
        
    }
    catch(SQLException ex){
        out.println(ex.getMessage());
    }
%>
