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
        <link rel="stylesheet" type="text/css" href="CSStyles/UserManagmentStyle.css">
        <link rel="icon" href="CSStyles/projectIcon.png" type="image/png"/>
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
                <input type="button" value="SIGN-IN" name="sign-in" onclick="location.href='CustomerLogin.jsp'"/>
                <input type="button" value="SIGN-UP" name="sign-up" onclick="location.href='reg.jsp'"/>
                </span>
            <%} 
            else {%>
                Welcome <%=session.getAttribute("userid")%>
                <input type="button" value="LOGOUT" name="sign-in" onclick="location.href='logout.jsp'"/>
                <%}%>
            </div>
            <div class="content">
                <center><h1><p>User <%=session.getAttribute("userid")%> - Buildings</p></h1></center>
                
                <%
                    ConfigurationSave confSave = (ConfigurationSave) session.getAttribute("confSave");
                    //Connessioni al db
                    Connection conn;
                    Statement mystmt;
                    ResultSet res;
                    DBConnection db;
                    ArrayList componentsCods = new ArrayList();
                    /*Inserimento building nella tabella*/
                    try{
                        db = new DBConnection();
                        mystmt = db.Connect();
                        /**/
                        String userid = (String) request.getSession().getAttribute("userid");
                        res = mystmt.executeQuery("select save.MCOD, save.CPUCOD, save.RCOD, save.GCOD, save.HCOD, save.PCOD, save.CSCOD from CustomerLogin join (select pur.MCOD, pur.CPUCOD, pur.RCOD, pur.GCOD, pur.HCOD, pur.PCOD, pur.CSCOD, sa.SAVECOD from SAVES as sa join PURCHASES as pur where sa.PURCOD = pur.COD) as save where save.SAVECOD = CustomerLogin.USERSAVE and USERNAME = '"+ userid +"' ");
                        /*Tabella intestazione*/
                        out.print("<table id=\"tableBuild\" class=\"tableSection\">");
                        out.print("<thead>");
                        out.print("<tr>");
                        out.print("<th>Motherboard</th>");
                        out.print("<th>Cpu</th>");
                        out.print("<th>Ram</th>");
                        out.print("<th>Graphic Card</th>");
                        out.print("<th>Hard Disk</th>");
                        out.print("<th>Power Supply</th>");
                        out.print("<th>Case</th>");
                        out.print("<th>Price</th>");
                        out.print("</tr>");
                        out.print("</thead>");
                        /*Tabella contenuto*/
                        out.print("<tbody>");
                        while(res.next())
                        {
                            for(int i = 1; i <= 7; i++)
                            {
                                componentsCods.add(String.valueOf(res.getInt(i)));
                            }
                            out.print("<tr>");
                            out.print("<td>"+new ComponentParser().getComponent("MOTHERBOARD", String.valueOf(res.getInt(1))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("CPU", String.valueOf(res.getInt(2))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("RAM", String.valueOf(res.getInt(3))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("GRAPHICS_CARD", String.valueOf(res.getInt(4))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("HDRIVE", String.valueOf(res.getInt(5))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("POWER_SUPPLY", String.valueOf(res.getInt(6))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getComponent("PCCASE", String.valueOf(res.getInt(7))).replace("-CC-", " ")+"</td>");
                            out.print("<td>"+new ComponentParser().getPrice(componentsCods)+"</td>");
                            out.print("</tr>");
                            componentsCods.clear();
                        }
                        out.print("</tbody>");
                        out.print("</table>");
                    }
                    catch(SQLException ex){
                        out.println("You must login first <a href='javascript:history.go(-1);'> Try again </a>" + ex);
                    }
                %>
            </div>
            <div class="footer">
                <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../indexadmin.jsp'"/>
                <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
            </div>
        </div>
    </body>
</html>
