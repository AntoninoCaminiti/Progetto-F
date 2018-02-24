<%@ page import="DatabaseElements.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Exceptions.*"%>

<html>
<head>
    <meta http-equiv="refresh" content="0; url=../CompPage/HDiskPage.jsp" />
</head>
<%
    String st1 = new String(request.getParameter("deletecod"));
    
    try{
    DBComponentController db = new DBComponentController();
    db.removeShrt("HDRIVE", st1.trim());
    db.closeall();
    }
    catch(DeleteComponentException del)
    {
        out.println(del.getMessage());
    }
    catch(SQLException e)
    {
        out.println(e.getMessage());
    }
    
%>


</html>