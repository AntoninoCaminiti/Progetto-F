<%@ page language="java" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="JSPElements.*"%>
<%@ page import="Components.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<%
    ConfigurationSave confSave = (ConfigurationSave) session.getAttribute("confSave");
    String mbcod = (String) request.getSession().getAttribute("mbCod");
    String mbField = null;
    if(mbcod!=null)
    {
        mbField = new ComponentParser().getComponent("MOTHERBOARD", mbcod);
    }
    String cpucod = (String) request.getSession().getAttribute("cpuCod");
    String cpuField = null;
    if(cpucod!=null)
    {
        cpuField = new ComponentParser().getComponent("CPU", cpucod);
    }

    String ramcod = (String) request.getSession().getAttribute("ramCod");
    String ramField = null;
    if(ramcod!=null)
    {
        ramField = new ComponentParser().getComponent("RAM", ramcod);
    }
    
    String gccod = (String) request.getSession().getAttribute("gcCod");
    String gcField = null;
    if(gccod!=null)
    {
        gcField = new ComponentParser().getComponent("GRAPHICS_CARD", gccod);
    }
    
    String hdcod = (String) request.getSession().getAttribute("hdCod");
    String hdField = null;
    if(hdcod!=null)
    {
        hdField = new ComponentParser().getComponent("HDRIVE", hdcod);
    }
    
    String pscod = (String) request.getSession().getAttribute("psCod");
    String psField = null;
    if(pscod!=null){
        psField = new ComponentParser().getComponent("POWER_SUPPLY", pscod);
    }
    
    String casecod = (String) request.getParameter("caseCod");
    
    String caseField = null;
    if(casecod!=null){
        caseField = new ComponentParser().getComponent("PCCASE", casecod);
    }
    
    Double price = Double.parseDouble(request.getParameter("price"));
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSStyles/LoginStyle.css">
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
        <title>Show Build</title>
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                 <form>
                    <h1>Your Building</h1>
                    <table>
                    <tr><label>Motherboard:</label><input type="text" id="mbField" value="<% if(mbField!=null) out.print(mbField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% if(cpuField!=null) out.print(cpuField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Graphic Card:</label><input type="text" id="gcField" value="<%if(gcField!=null) out.print(gcField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Hard Disk:</label><input type="text" id="hdField" value="<%if(hdField!=null) out.print(hdField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Power Supply:</label><input type="text" id="psField" value="<%if(psField!=null) out.print(psField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Case:</label><input type="text" id="caseField" value="<%if(caseField!=null) out.print(caseField.replace("-CC-", " "));%>" disabled="disabled"></tr><br><hr>
                    <tr><label>Price:</label><input type="text" id="priceField" value="<% if(price!=null) out.print(price); %>" disabled="disabled"><br></tr>
                </table>
                 </form>
            </div>
        </div>
    </body>
</html>
