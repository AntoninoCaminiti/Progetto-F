<%@ page import ="java.sql.*" %>
<%@ page language="java" %>
<%@ page import="DatabaseElements.*" %>

<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    
    Connection conn = new DBConnection().Connect();
    Statement st = conn.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from CustomerLogin where USERNAME='" + userid + "' and PASS='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        response.sendRedirect(request.getParameter("uref"));
    } else {
        response.sendRedirect(request.getParameter("uref"));
    }
%>
