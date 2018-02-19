<%@ page language="java" %>


<%
    session.setAttribute("useridadm", null);
    session.invalidate();
    response.sendRedirect("../index.html");
    
%>
