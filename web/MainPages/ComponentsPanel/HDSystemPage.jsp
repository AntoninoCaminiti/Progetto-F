<%@ page import="JSPElements.*"%>
<%@ page import="Components.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userc" scope="session" class="Components.UserCart"/>

<%
    
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
    mbField = new ComponentParser().getComponent(Integer.parseInt(mbcod)).getBrand()+ " " + new ComponentParser().getComponent(Integer.parseInt(mbcod)).getModel();
    String cpucod = null;
    
    if(request.getSession().getAttribute("cpuCod")!=null)
    {
        cpucod = String.valueOf(new ComponentParser().getComponent(Integer.parseInt(cpucod)));
    }
    if(request.getSession().getAttribute("cpuCod")==null)
    {
        cpucod = new CookiesHandler().getCookie("CPUCOD", request);
       
    }
    
    String cpuField = new ComponentParser().getComponent(Integer.parseInt(cpucod)).getBrand()+ " " + new ComponentParser().getComponent(Integer.parseInt(cpucod)).getModel();
    
    
    String ramcod = null;
    
    request.getSession().setAttribute("ramCod", ramcod);
    

    String ramField = null;
    if(request.getSession().getAttribute("ramCod")!=null)
    {
        String.valueOf(new ComponentParser().getComponent(Integer.parseInt(ramcod)));
    }
    if(request.getSession().getAttribute("ramCod")==null)
    {
        ramcod = new CookiesHandler().getCookie("RAMCOD", request);
       
    }
    
    ramField = new ComponentParser().getComponent(Integer.parseInt(ramcod)).getBrand()+ " " + new ComponentParser().getComponent(Integer.parseInt(ramcod)).getModel();
    
    String gccod = null;
    
    request.getSession().setAttribute("gcCod", gccod);
    

    String gcField = null;
    if(request.getSession().getAttribute("gcCod")!=null)
    {
        String.valueOf(new ComponentParser().getComponent(Integer.parseInt(gccod)));
    }
    if(request.getSession().getAttribute("gcCod")==null)
    {
        gccod = new CookiesHandler().getCookie("GCCOD", request);
       
    }
    
    gcField = new ComponentParser().getComponent(Integer.parseInt(gccod)).getBrand()+ " " + new ComponentParser().getComponent(Integer.parseInt(gccod)).getModel();
    
    
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
        <title>VIRTUAL - Choose Your HD</title>
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
                <input type="button" value="LOGOUT" name="sign-in" onclick="location.href='../../Users/Logout.jsp'"/>
                <%}%>
        </div>         
        <div class="sidebar">
            <table id="configTable" border="0">
                <tr><label>Motherboard:</label><input type="text" id="mbField" value="<% if(mbField!=null) out.print(mbField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% if(cpuField!=null) out.print(cpuField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"></tr><br>
                <tr><label>Graphic Card:</label><input type="text" id="gcField" value="<%if(gcField!=null) out.print(gcField.replace("-CC-", " "));%>" disabled="disabled"></tr><br>
                <tr><label>Hard Disk:</label><input type="text" id="hdField" disabled="disabled"><input type="text" class="hidden" value="<% if(price!=null) out.print(price); %>" id="hdPrice"></tr><br>
                <tr><label>Power Supply:</label><input type="text" id="psField" disabled="disabled"></tr><br>
                <tr><label>Case:</label><input type="text" id="caseField" disabled="disabled"></tr><br><hr>
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
                <li id="active1"><img src="../../CSStyles/IconComponents/HardDiskIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/PowerSupplyIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/CaseIcon.png"></li>
            </ul>
            <!-- Loading HDisk components in a table-->
            <%
                out.println(new HTMLTableCreator(userc).createHDrive(false, Integer.parseInt(gccod)));
            %>
            <script>
                var hdIndex;
                var tableHD = document.getElementById("table5");
                // get selected row
                // display selected row data in text input        
                for(var i = 1; i < tableHD.rows.length; i++){
                    tableHD.rows[i].onclick = function(){
                    //Remove the previous selected row
                    if (typeof hdIndex !== "undefined"){
                        tableHD.rows[hdIndex].classList.toggle("selected");
                    }
                    //Get the selected row index
                    hdIndex = this.rowIndex;
                    //Add class to the selected row
                    this.classList.toggle("selected");
                    document.getElementById("hdField").value = this.cells[0].innerHTML + " " + this.cells[1].innerHTML;
                    document.getElementById("priceField").value = (parseFloat(document.getElementById("hdPrice").value) + parseFloat(this.cells[8].innerHTML)).toFixed(2);
                    document.getElementById("hdCod").value = this.cells[9].innerHTML;
                    document.getElementById("price").value = document.getElementById("priceField").value;
                    document.getElementById("nextbtn").disabled = false;
                    document.cookie = "HDCOD=" + document.getElementById("hdCod").value;
                    };
                }
            </script>
            <form action="PSSystemPage.jsp" method="POST">
                <input type="hidden" id="hdCod" name="hdCod"/>
                <input type="hidden" id="price" name="price"/>
                <input type="submit" disabled="" id="nextbtn" value="Next"/>
            </form>
            <a href="javascript:history.go(-1)" onMouseOver="self.status.referrer; return true;"><input type="button" class="btnPrev" value="Previous"></a>
        </div>
        <div class="footer">
            <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
            <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
        </div>
    </div>
    </body>
</html>
