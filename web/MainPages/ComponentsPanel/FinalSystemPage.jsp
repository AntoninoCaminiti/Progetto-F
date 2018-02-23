<%@ page import="JSPElements.*"%>
<%@ page import="Components.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ConfigurationSave confSave = (ConfigurationSave) session.getAttribute("confSave");
    String mbcod = null;
    String mbField = null;
    if(request.getSession().getAttribute("mbCod")!=null)
    {
        mbcod = (String) request.getSession().getAttribute("mbCod");
    }
    
    if(request.getSession().getAttribute("mbCod")==null)
    {
        mbcod = new CookiesHandler().getCookie("MBCOD", request);
       
    }
    mbField = new ComponentParser().getComponent("MOTHERBOARD", mbcod).replace("-CC-", " ");
    String cpucod = null;
    
    if(request.getSession().getAttribute("cpuCod")!=null)
    {
        cpucod = new ComponentParser().getComponent("CPU", cpucod);
    }
    if(request.getSession().getAttribute("cpuCod")==null)
    {
        cpucod = new CookiesHandler().getCookie("CPUCOD", request);
       
    }
    
    String cpuField = new ComponentParser().getComponent("CPU", cpucod).replace("-CC-", " ");
    
    
    String ramcod = null;
    
    request.getSession().setAttribute("ramCod", ramcod);
    
    confSave.setRAMCod(ramcod);
    session.setAttribute("confSave", confSave);
    String ramField = null;
    if(request.getSession().getAttribute("ramCod")!=null)
    {
        ramcod = new ComponentParser().getComponent("RAM", ramcod);
    }
    if(request.getSession().getAttribute("ramCod")==null)
    {
        ramcod = new CookiesHandler().getCookie("RAMCOD", request);
       
    }
    
    ramField = new ComponentParser().getComponent("RAM", ramcod).replace("-CC-", " ");
    
    String gccod = null;
    
    request.getSession().setAttribute("gcCod", gccod);
    
    confSave.setGCCod(gccod);
    session.setAttribute("confSave", confSave);
    String gcField = null;
    if(request.getSession().getAttribute("gcCod")!=null)
    {
        gccod = new ComponentParser().getComponent("GRAPHICS_CARD", gccod);
    }
    if(request.getSession().getAttribute("gcCod")==null)
    {
        gccod = new CookiesHandler().getCookie("GCCOD", request);
       
    }
    
    gcField = new ComponentParser().getComponent("GRAPHICS_CARD", gccod).replace("-CC-", " ");
    
    
    String hdcod = null;
    
    request.getSession().setAttribute("hdCod", hdcod);
    
    confSave.setHDCod(hdcod);
    session.setAttribute("confSave", confSave);
    String hdField = null;
    if(request.getSession().getAttribute("hdCod")!=null)
    {
        hdcod = new ComponentParser().getComponent("HDRIVE", hdcod);
    }
    if(request.getSession().getAttribute("hdCod")==null)
    {
        hdcod = new CookiesHandler().getCookie("HDCOD", request);
       
    }
    
    hdField = new ComponentParser().getComponent("HDRIVE", hdcod).replace("-CC-", " ");
    
    String pscod = null;
    
    request.getSession().setAttribute("psCod", pscod);
    
    confSave.setPSCod(pscod);
    session.setAttribute("confSave", confSave);
    String psField = null;
    if(request.getSession().getAttribute("psCod")!=null)
    {
        pscod = new ComponentParser().getComponent("POWER_SUPPLY", pscod);
    }
    if(request.getSession().getAttribute("psCod")==null)
    {
        pscod = new CookiesHandler().getCookie("PSCOD", request);
       
    }
    
    psField = new ComponentParser().getComponent("POWER_SUPPLY", pscod).replace("-CC-", " ");
    
    String casecod = null;
    
    request.getSession().setAttribute("caseCod", casecod);
    
    confSave.setPCCod(casecod);
    session.setAttribute("confSave", confSave);
    String caseField = null;
    if(request.getSession().getAttribute("caseCod")!=null)
    {
        casecod = new ComponentParser().getComponent("PCCASE", casecod);
    }
    if(request.getSession().getAttribute("caseCod")==null)
    {
        casecod = new CookiesHandler().getCookie("CASECOD", request);
       
    }
    
    caseField = new ComponentParser().getComponent("PCCASE", casecod).replace("-CC-", " ");
    
    Double price = null;
    if(request.getParameter("price") != null){
        price = Double.parseDouble(request.getParameter("price"));
        new Cookie("PRICE", request.getParameter("price"));
    }
    if(request.getParameter("price")==null)
    {
        price = Double.parseDouble(new CookiesHandler().getCookie("PRICE", request));
    }    
%>
<!DOCTYPE html>
<html>
    <head>
        <title>VIRTUAL</title>
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
        <link rel="stylesheet" type="text/css" href="./../../CSStyles/FinalPage.css">
    </head>
    <body>
        <div class="grid">
            <div class="header"><img src="../../CSStyles/IconComponents/Banner1.png"></div>
            <div class="navbar">
                <%//Success of login
                if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
                %>
                    You are not logged in
                    <input type="button" value="SIGN-IN" name="sign-in" onclick="location.href='../../Users/Login.html'"/>
                    <input type="button" value="SIGN-UP" name="sign-up" onclick="location.href='../../Users/RegistrationForm.html'"/>
                <%} 
                else {%>
                    Welcome <a href="./../../Users/UserManagement.jsp" > <%=session.getAttribute("userid")%> </a>
                    <input type="button" value="LOGOUT" name="sign-in" onclick="location.href='../../User/Logout.jsp'"/>
                <%}%>
            </div>
            <div class="content">
                <center>
                    <h1>Your Building:</h1><br>
                <table>
                    <tr><label>Motherboard:</label><input type="text" id="mbField" value="<% if(mbField!=null) out.print(mbField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% if(cpuField!=null) out.print(cpuField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                    <tr><label>Graphic Card:</label><input type="text" id="gcField" value="<%if(gcField!=null) out.print(gcField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Hard Disk:</label><input type="text" id="hdField" value="<%if(hdField!=null) out.print(hdField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Power Supply:</label><input type="text" id="psField" value="<%if(psField!=null) out.print(psField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Case:</label><input type="text" id="caseField" value="<%if(caseField!=null) out.print(caseField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                    <tr><label>Price:</label><input type="text" id="priceField" value="<% if(price!=null) out.print(price); %>" disabled="disabled"><br></tr><hr>
                </table>
                <form action="AddBuild.jsp" method="post"><button class="btn"><span>Save it!</span><br></button></form>
                <a href="javascript:history.go(-1)" onMouseOver="document.referrer; return true;"><input type="button" value="Previous"></a>
                </center>    
            </div>
            <div class="footer">
                <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
                <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
            </div>
        </div>
    </body>
</html>
