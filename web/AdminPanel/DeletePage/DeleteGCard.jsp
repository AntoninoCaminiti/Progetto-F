<%@ page import="DatabaseElements.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Exceptions.*"%>

<html>
<head>
    <meta http-equiv="refresh" content="0; url=../CompPage/GCardPage.jsp" />
</head>
    
    
<%
    String st1 = request.getParameter("deletecod");
    
    
    
    try{
    DBComponentController db = new DBComponentController();
    db.removeShrt("GRAPHICS_CARD",st1.trim());
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