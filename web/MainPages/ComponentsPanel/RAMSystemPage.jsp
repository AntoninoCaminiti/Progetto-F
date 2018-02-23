<%@ page import="JSPElements.*"%>
<%@ page import="Components.*"%>
<%@ page import="DatabaseElements.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ConfigurationSave confSave = (ConfigurationSave) session.getAttribute("confSave");
    String mbcod = null;
    
    if(request.getSession().getAttribute("mbCod")!=null)
    {
        mbcod = (String) request.getSession().getAttribute("mbCod");
    }
    if(request.getSession().getAttribute("mbCod")==null)
    {
        mbcod = new CookiesHandler().getCookie("MBCOD", request);
       
    }
    
    String input [] = new ComponentParser().getComponent("MOTHERBOARD", mbcod).split("-CC-");
    String brand = input[0];
    String model = input[1];
    
    String cpucod = null;
    if(request.getSession().getAttribute("cpuCod")!=null)
    {
        cpucod = (String) request.getSession().getAttribute("cpuCod");
    }
    if(request.getSession().getAttribute("cpuCod")==null)
    {
        cpucod = new CookiesHandler().getCookie("CPUCOD", request);
       
    }
    
    //request.getSession().setAttribute("cpuCod", cpucod);
    
    confSave.setCPUCod(cpucod);
    session.setAttribute("confSave", confSave);
    String cpuData = null;
    if(cpucod!=null)
    {
        cpuData = new ComponentParser().getComponent("CPU", cpucod);
    }
    
    Double price = null;
    if(request.getParameter("price") != null){
        price = Double.parseDouble(request.getParameter("price"));
        new Cookie("PRICE", request.getParameter("price"));
    }
    if(request.getParameter("price")==null)
    {
        price = Double.parseDouble(new CookiesHandler().getCookie("PRICE", request));
    }    
    String ramcod=null;
    String ramField=null;/*
    if((ramcod = (String) request.getSession().getAttribute("ramCod"))!=null)
    {
        ramField = new ComponentParser().getComponent("RAM", ramcod);
    }*/
    System.out.print("Finally "+ confSave.getMBCod() + " "+ confSave.getRAMCod() + " "+ confSave.getGCCod() + " "+ confSave.getPSCod() + " "+ confSave.getHDCod() + " "+ confSave.getPCCod() + " ");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../../CSStyles/BuildSystemStyle.css">
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
        <title>VIRTUAL - Choose Your RAM</title>
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
                <!--input type="hidden" id="temp" name="temp" value="<% out.print(cpucod); %>"-->
                <tr><label>Motherboard:</label><input type="text" id="mbField" value ="<% out.print(brand + " " + model); %>" disabled="disabled"></tr><br>
                <tr><label>Cpu:</label><input type="text" id="cpuField" value="<% out.print(cpuData.replace("-CC-", " ")); %>" disabled="disabled"><input type="text" class="hidden"  id="cpuPrice"></tr><br>
                <tr><label>Ram:</label><input type="text" id="ramField" value="<% if(ramField!=null) out.print(ramField.replace("-CC-", " ")); %>" disabled="disabled"><input type="text" class="hidden" value="<%out.print(price);%>" id="ramPrice"></tr><br>
                <tr><label>Graphic Card:</label><input type="text" id="gcField" disabled="disabled"><input type="text" class="hidden" id="gcPrice"></tr><br>
                <tr><label>Hard Disk:</label><input type="text" id="hdField" disabled="disabled"><input type="text" class="hidden" id="hdPrice"></tr><br>
                <tr><label>Power Supply:</label><input type="text" id="psField" disabled="disabled"><input type="text" class="hidden" id="psPrice"></tr><br>
                <tr><label>Case:</label><input type="text" id="caseField" disabled="disabled"><input type="text" class="hidden" id="casePrice"></tr><br><hr>
                <tr><label>Price:</label><input type="text" value="<% out.print(price); %>" id="priceField" disabled="disabled"><br></tr>
            </table>
        </div>
        <div class="content">
            <!-- Progressbar -->
            <ul id="progressbar">
                <li><img class="noactive" src="../../CSStyles/IconComponents/MotherboardIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/CPUIcon.png"></li>
                <li id="active1"><img src="../../CSStyles/IconComponents/RamIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/GraphicCardIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/HardDiskIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/PowerSupplyIcon.png"></li>
                <li><img class="noactive" src="../../CSStyles/IconComponents/CaseIcon.png"></li>
            </ul>
            <!-- Loading RAM components in a table-->
            <%
                Boolean status = new DBUserHandler().getRAMStatusConstr();
                //
                ConfigurationSave cs = (ConfigurationSave) session.getAttribute("confsave");
                //cs.sumPrice(Double.parseDouble(request.getParameter("NEXTPRI")));
                //System.out.println(cs.getBrand() + " " + cs.getModel() + " " + cs.getPrice());
                
                out.print(new HTMLTableCreator().createRAM(false, status, brand, model));
            %>
            <script>
                var urlForward;
                if(document.getElementById("ramField").value == null || document.getElementById("ramField").value == "")
                {
                    //urlForward = document.referrer.replace("CPUSystemPage", "GCSystemPage") + document.getElementById("temp").value+"&priceField="+document.getElementById("priceField").value;
                }
                var urlBackward = "CPUSystemPage.jsp";
                var ramIndex;
                var tableRAM = document.getElementById("table3");
                // get selected row
                // display selected row data in text input        
                for(var i = 1; i < tableRAM.rows.length; i++){
                    tableRAM.rows[i].onclick = function(){
                        //Remove the previous selected row
                        if (typeof ramIndex !== "undefined"){
                            tableRAM.rows[ramIndex].classList.toggle("selected");
                        }
                        //Get the selected row index
                        ramIndex = this.rowIndex;
                        //Add class to the selected row
                        this.classList.toggle("selected");
                        document.getElementById("ramField").value = this.cells[0].innerHTML + " " + this.cells[1].innerHTML;
                        document.getElementById("priceField").value = (parseFloat(document.getElementById("ramPrice").value) + parseFloat(this.cells[8].innerHTML)).toFixed(2);
                        document.getElementById("ramCod").value = this.cells[9].innerHTML;
                        document.getElementById("price").value = document.getElementById("priceField").value;
                        document.getElementById("nextbtn").disabled = false;
                        document.cookie = "RAMCOD=" + document.getElementById("ramCod").value;
                        
                    };
                }
            </script>
            <form action="GCSystemPage.jsp" method="POST">
                <input type="hidden" id="ramCod" name="ramCod"/>
                <input type="hidden" id="price" name="price"/>
                <input type="submit" disabled="" id="nextbtn" value="Next"/>
            </form>
            <a href="javascript:history.go(-1)" onMouseOver="document.referrer; return true;"><input type="button" class="btnPrev" value="Previous"></a>
            <!--input  type="button" value="Previous" name="previous" onclick="location.href=urlBackward"/-->
            <!--input  type="button" value="Next" name="next" onclick="location.href=urlForward"/-->
            <!--a href="javascript:history.go(-1)" onMouseOver="self.status.referrer; return true;"><input type="button" value="Previous"></a-->
	</div>
        <div class="footer">
            <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
            <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
        </div>
    </div>
    </body>
</html>
