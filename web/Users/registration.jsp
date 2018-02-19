<%@ page language="java" %>
<%@ page import ="DatabaseElements.*" %>
<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String email = request.getParameter("email");
    String addr = request.getParameter("address");
    
    DBUserHandler db = new DBUserHandler();
    
    
    if(db.addUser(user, pwd, email, addr)==true)
    {
    session.setAttribute("userid", user);
    response.sendRedirect("./MainPages/ComponentsPanel/MBSystemPage.jsp");    
    }
    else
    {
    
    response.sendRedirect("ExistingUserError.jsp");   
    }
    
        
%>
