<%@ page language="java" %>
session_start();
<%
if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in
<a href="Login.html">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<a href='Logout.jsp'>Log out</a>
<%
}
%>
