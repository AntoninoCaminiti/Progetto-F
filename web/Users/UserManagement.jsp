<%@ page import="JSPElements.*"%>
<%@ page import="DatabaseElements.*"%>
<%@ page import="Components.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSStyles/UserManagmentStyle.css">
        <link rel="icon" href="../CSStyles/projectIcon.png" type="image/png"/>
        <title>VIRTUAL - User Managment</title>
    </head>
    <body>
        <div class="grid">
            <div class="header">BANNER</div>
            <div class="navbar">
            <%//Success of login
            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
            %>
                <span style="display: inline;">
                You are not logged in
                <input type="button" value="SIGN-IN" name="sign-in" onclick="location.href='Login.html'"/>
                <input type="button" value="SIGN-UP" name="sign-up" onclick="location.href='RegistrationForm.html'"/>
                </span>
            <%} 
            else {%>
                Welcome <%=session.getAttribute("userid")%>
                <input type="button" value="LOGOUT" name="sign-in" onclick="location.href='Logout.jsp'"/>
                <%}%>
            </div>
            <div class="content">
                <center><h1><p>User <%=session.getAttribute("userid")%> - Buildings</p></h1></center>
                <%
                    String user = (String) session.getAttribute("userid"); 
                    out.print(new UserConfigCreator().createTable(user));
                %>
            </div>
            <div class="footer">
                <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
                <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../index.html'"/>
            </div>
        </div>
    </body>
</html>
