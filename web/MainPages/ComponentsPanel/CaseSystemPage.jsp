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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../../CSStyles/BuildSystemStyle.css">
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
        <title>VIRTUAL - Choose Your Case</title>
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
        <div class="sidebar">
            <table id="configTable" border="0">
                <tr><label>Motherboard:</label><input type="text" id="mbField" value="<% if(mbField!=null) out.print(mbField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% if(cpuField!=null) out.print(cpuField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Graphic Card:</label><input type="text" id="gcField" value="<%if(gcField!=null) out.print(gcField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                <tr><label>Hard Disk:</label><input type="text" id="hdField" value="<%if(hdField!=null) out.print(hdField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                <tr><label>Power Supply:</label><input type="text" id="psField" value="<%if(psField!=null) out.print(psField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                <tr><label>Case:</label><input type="text" id="caseField" disabled="disabled"><input type="text" class="hidden" value="<% if(price!=null) out.print(price); %>" id="casePrice"></tr><br><hr>
                <tr><label>Price:</label><input type="text" id="priceField" value="<% if(price!=null) out.print(price); %>" disabled="disabled"><br></tr>
            </table>
        </div>
        <div class="content">
            <!-- Progressbar -->
            <ul id="progressbar">
                    <li><img class="noactive" src="../../CSStyles/IconComponents/MotherboardIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/CPUIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/RamIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/GraphicCardIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/HardDiskIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/PowerSupplyIcon.png"></li>
                    <li id="active1"><img src="../../CSStyles/IconComponents/CaseIcon.png"></li>
            </ul>
            <!-- Loading HDisk components in a table-->
            <%
                out.println(new HTMLTableCreator().createCase(false));
            %>
            <script>
                var caseIndex;
                var tableCase = document.getElementById("table7");
                // get selected row
                // display selected row data in text input        
                for(var i = 1; i < tableCase.rows.length; i++)
                {
                    tableCase.rows[i].onclick = function()
                    {
                        //Remove the previous selected row
                        if (typeof caseIndex !== "undefined"){
                            tableCase.rows[caseIndex].classList.toggle("selected");
                        }
                        //Get the selected row index
                        caseIndex = this.rowIndex;
                        //Add class to the selected row
                        this.classList.toggle("selected");

                        document.getElementById("caseField").value = this.cells[0].innerHTML + " " + this.cells[1].innerHTML;
                        document.getElementById("priceField").value = (parseFloat(document.getElementById("casePrice").value)+parseFloat(this.cells[6].innerHTML)).toFixed(2);
                        document.getElementById("caseCod").value = this.cells[7].innerHTML;
                        document.getElementById("price").value = document.getElementById("priceField").value;
                        document.getElementById("nextbtn").disabled = false;
                        document.cookie = "CASECOD=" + document.getElementById("caseCod").value;
                     };
                }
            </script>
            <form action="FinalSystemPage.jsp" method="POST">
                <input type="hidden" id="caseCod" name="caseCod"/>
                <input type="hidden" id="price" name="price" value="<% if(price!=null) out.print(price); %>"/>
                <input type="submit" disabled="" id="nextbtn" value="Next"/>
            </form>
            <a href="javascript:history.go(-1)" onMouseOver="document.referrer; return true;"><input type="button" class="btnPrev" value="Previous"></a>
        </div>
        <div class="footer">
            <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
            <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
        </div>
    </div>
    </body>
</html>
