<%@ page import ="java.sql.*" %>
<%@ page language="java" %>
<%@ page import="DatabaseElements.*" %>


<%
    String useridadm = request.getParameter("uname");    
    String pwdadm = request.getParameter("pass");
    
    
    Statement st = new DBConnection().Connect();
    ResultSet rs;
    rs = st.executeQuery("select * from ADMINLOGIN where USERNAME='" + useridadm + "' and PASS='" + pwdadm + "'");
    if (rs.next()) {
        
        response.sendRedirect("./CompPage/MotherboardPage.jsp");
        session.setAttribute("useridadm", useridadm);
        out.println("Welcome " + useridadm);
    } else {
        response.sendRedirect("ErrorLogin.html");
        out.println("Invalid password <a href='Login.html'>try again</a>");
    }
%>