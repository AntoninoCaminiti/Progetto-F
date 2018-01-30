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
    
    if(cpucod!=null)
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
        <title>VIRTUAL - Choose Your Graphic Card</title>
    </head>
    <body>
    <div class="grid">
        <div class="header">BANNER</div>
        <div class="navbar">
            <%//Success of login
            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
            %>
                You are not logged in
                <input type="button" value="SIGN-IN" name="sign-in" onclick="location.href='../../CustomerLogin.jsp'"/>
                <input type="button" value="SIGN-UP" name="sign-up" onclick="location.href='../../reg.jsp'"/>
            <%} 
            else {%>
                Welcome <a href="./../../UserManagment.jsp" > <%=session.getAttribute("userid")%> </a>
                <input type="button" value="LOGOUT" name="sign-in" onclick="location.href='../../logout.jsp'"/>
            <%}%>
        </div>
        <div class="sidebar">
            <table id="configTable" border="0">
                <tr><label>Motherboard:</label><input type="text" id="mbField" value="<% if(mbField!=null) out.print(mbField.replace("-CC-", " ")); %>" disabled="disabled"><input type="text" class="hidden" id="mbPrice"></tr><br>
                <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% if(cpuField!=null) out.print(cpuField.replace("-CC-", " ")); %>" disabled="disabled"><input type="text" class="hidden" id="cpuPrice"></tr><br>
                <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"><input type="text" class="hidden" id="ramPrice"></tr><br>
                <tr><label>Graphic Card:</label><input type="text" id="gcField" disabled="disabled"><input type="text" class="hidden" value="<% if(price!=null) out.print(price); %>" id="gcPrice"></tr><br>
                <tr><label>Hard Disk:</label><input type="text" id="hdField" disabled="disabled"><input type="text" class="hidden" id="hdPrice"></tr><br>
                <tr><label>Power Supply:</label><input type="text" id="psField" disabled="disabled"><input type="text" class="hidden" id="psPrice"></tr><br>
                <tr><label>Case:</label><input type="text" id="caseField" disabled="disabled"><input type="text" class="hidden" id="casePrice"></tr><br><hr>
                <tr><label>Price:</label><input type="text" id="priceField" value="<% if(price!=null) out.print(price); %>" disabled="disabled"><br></tr>
            </table>
        </div>
        <div class="content">
            <!-- Progressbar -->
            <ul id="progressbar">
                    <li><img class="noactive" src="../../CSStyles/IconComponents/Processor-64.png"> Motherboard</li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/vector_373_08-64.png">Cpu</li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/ram-64.png">Ram</li>
                    <li id="active1"><img src="../../CSStyles/IconComponents/graphic_card-64.png">Graphic Card</li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/hard-disk-64.png">Hard Disk</li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/plug-64.png">Power Supply</li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/vector_373_24-64.png">Case</li>
            </ul>
            <!-- Loading GCard components in a table-->
            <%
                out.println(new HTMLTableCreator().createGCard(false));
            %>
            <script>
                var gcIndex;
                var tableGC = document.getElementById("table4");
                // get selected row
                // display selected row data in text input        
                for(var i = 1; i < tableGC.rows.length; i++)
                {
                    tableGC.rows[i].onclick = function()
                    {
                        //Remove the previous selected row
                        if (typeof gcIndex !== "undefined"){ 
                            tableGC.rows[gcIndex].classList.toggle("selected");
                        }
                        //Get the selected row index
                        gcIndex = this.rowIndex;
                        //Add class to the selected row
                        this.classList.toggle("selected");
                        document.getElementById("gcField").value = this.cells[0].innerHTML + " " + this.cells[1].innerHTML;
                        document.getElementById("priceField").value = (parseFloat(document.getElementById("gcPrice").value) + parseFloat(this.cells[8].innerHTML)).toFixed(2);
                        document.getElementById("gcCod").value = this.cells[9].innerHTML;
                        document.getElementById("price").value = document.getElementById("priceField").value;
                        document.getElementById("nextbtn").disabled = false;
                        document.cookie = "GCCOD=" + document.getElementById("gcCod").value;
                     };
                }
            </script>
            <form action="HDSystemPage.jsp" method="POST">
                <input type="hidden" id="gcCod" name="gcCod"/>
                <input type="hidden" id="price" name="price"/>
                <input type="submit" disabled="" id="nextbtn" value="Next"/>
            </form>
            <a href="javascript:history.go(-1)" onMouseOver="document.referrer; return true;"><input type="button" value="Previous"></a>
        </div>
        <div class="footer">
            <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../indexadmin.jsp'"/>
            <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
        </div>
    </div>
    </body>
</html>