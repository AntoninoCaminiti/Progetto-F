<%@ page import ="java.sql.*" %>
<%@ page language="java" %>
<%@ page import="DatabaseElements.*" %>

<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    
    
    Statement st = new DBConnection().Connect();
    ResultSet rs;
    rs = st.executeQuery("select * from CustomerLogin where USERNAME='" + userid + "' and PASS='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        
        %>
        <script>window.history.go(-2);</script>
        
                
               <%
    } else {
        out.println("Invalid password <a href='CustomerLogin.jsp'>try again</a>");
    }
%>
