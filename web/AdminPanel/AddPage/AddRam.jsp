<%@ page import="Components.RAMLoader"%>
<%@ page import="DatabaseElements.*"%>
<%@ page import="Exceptions.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=ISO-8859-5" %>


<%
    //legge i valori ricevuti dal form HTML
    String Stringa1 = new String (request.getParameter("brand"));
    String Stringa2 = new String (request.getParameter("model"));
    String Stringa3 = new String (request.getParameter("ram_type"));
    String Stringa4 = new String (request.getParameter("speed"));
    String Stringa5 = new String (request.getParameter("tdp"));
    int Int1 = Integer.parseInt(Stringa5);
    String Stringa6 = new String (request.getParameter("number_of_modules"));
    int Int2 = Integer.parseInt(Stringa6);
    String Stringa7 = new String (request.getParameter("size_of_modules"));
    int Int3 = Integer.parseInt(Stringa7);
    String Stringa8 = new String (request.getParameter("size"));
    int Int4 = Integer.parseInt(Stringa8);	
    String Stringa9 = new String (request.getParameter("price"));
    double db1 = Double.parseDouble(Stringa9);
    try{
        DBConnection db = new DBConnection();
        RAMLoader rm = new RAMLoader();
        db.Connect();
        db.filldbRAM(Stringa1, Stringa2, Stringa3, Stringa4, Int1, Int2, Int3, Int4, db1);
        out.print("<meta http-equiv=\"refresh\" content=\"0; url=../CompPage/RamPage.jsp\" />");
    }
    catch(ErrorInsertComponent eic)
    {
        out.println("<font size =\"100\" color=\"red\">" + eic.getMessage() + "</font>");
        out.print("<meta http-equiv=\"refresh\" content=\"3; url=../CompPage/RamPage.jsp\" />");
        
    }
    catch(SQLException ex){
            out.println("Connessione fallita.");
    }
%>