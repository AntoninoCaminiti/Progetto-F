<%@ page import="Components.DBConnection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>

<html>
    <head>
        <meta http-equiv="refresh" content="0; url=../CompPage/CpuPage.jsp" />
    </head>
    <%
        String st1 = new String(request.getParameter("brand_delete"));
        String st2 = new String(request.getParameter("model_delete"));

        try{
            DBConnection db = new DBConnection();
            db.Connect();
            db.removeShCPU(st1.trim(), st2.trim());
            db.closeall();
        }
        catch(SQLException e)
        {}
    %>
</html>

