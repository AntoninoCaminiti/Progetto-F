<%@ page import="DatabaseElements.*"%>
<%@ page import="JSPElements.*"%>
<%@ page import="Components.*"%>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="userc" scope="session" class="Components.UserCart"/>
<%
    
    String mbcod = "";
    Double price = null;
    
    if(new CookiesHandler().getCookie("MBCOD", request)!=null)
    {
        mbcod = new CookiesHandler().getCookie("MBCOD", request);
    }

    
    if(request.getParameter("price") != null){
        price = Double.parseDouble(request.getParameter("price"));
        new Cookie("PRICE", request.getParameter("price"));
    }
    if(request.getParameter("price")==null)
    {
        price = Double.parseDouble(new CookiesHandler().getCookie("PRICE", request));
    }

    
    String input [] = null;
    String brand = null;
    String model = null;
    if(mbcod != null)
    {
        
        brand = new ComponentParser().getComponent(Integer.parseInt(mbcod)).getBrand();
        model = new ComponentParser().getComponent(Integer.parseInt(mbcod)).getModel();
    }
    
    //CPU data init. for return case
    String cpuField=null;
    String cpucod = null;
    if((cpucod = (String) request.getSession().getAttribute("cpuCod"))!=null)
    {
        cpuField = new ComponentParser().getComponent(Integer.parseInt(cpucod)).getBrand() + " " + new ComponentParser().getComponent(Integer.parseInt(cpucod)).getModel();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./../../CSStyles/BuildSystemStyle.css">
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
        <title>VIRTUAL - Choose Your CPU</title>
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
                    <!--input type="hidden" id="temp" name="temp" value="<%out.print(mbcod);%>"-->
                    <tr><label>Motherboard:</label><input type="text" value="<% out.println(brand + " " + model); %>"  id="mbField" disabled="disabled"></input> </tr><br>
                    <tr><label>Cpu:</label><input type="text" id="cpuField" value='<% if(cpuField != null) out.print(cpuField.replace("-CC-", " ")); %>' disabled="disabled"><input type="text" class="hidden" value="<% out.print(price); %>" id="cpuPrice"></tr><br>
                    <tr><label>Ram:</label><input type="text" id="ramField" disabled="disabled"></tr><br>
                    <tr><label>Graphic Card:</label><input type="text" id="gcField" disabled="disabled"></tr><br>
                    <tr><label>Hard Disk:</label><input type="text" id="hdField" disabled="disabled"></tr><br>
                    <tr><label>Power Supply:</label><input type="text" id="psField" disabled="disabled"></tr><br>
                    <tr><label>Case:</label><input type="text" id="caseField" disabled="disabled"></tr><br><hr>
                    <tr><label>Price:</label><input type="text" value="<% out.println(price); %>" id="priceField" disabled="disabled"></input><br></tr>
                </table>
            </div>
            <div class="content">
                <!-- Progressbar -->
                <ul id="progressbar">
                    <li><img class="noactive" src="../../CSStyles/IconComponents/MotherboardIcon.png"></li>
                    <li id="active1"><img src="../../CSStyles/IconComponents/CPUIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/RamIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/GraphicCardIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/HardDiskIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/PowerSupplyIcon.png"></li>
                    <li><img class="noactive" src="../../CSStyles/IconComponents/CaseIcon.png"></li>
                </ul>
                <!-- Loading CPU components in a table-->
                <%
                    Boolean flagAdmin = new DBUserHandler().getCPUStatusConstr();
                    System.out.println(mbcod+flagAdmin);
                    /*Default TRUE = Compatibilità*/
                    if(flagAdmin == true){
                        out.print(new HTMLTableCreator(userc).createCPU(false, flagAdmin, Integer.parseInt(mbcod)));
                    }
                    if(flagAdmin == false){
                        out.print(new HTMLTableCreator(userc).createCPU(false, flagAdmin, Integer.parseInt(mbcod)));
                    }
                %>
                <script>
                    var urlForward;
                    if(document.getElementById("cpuField").value == null || document.getElementById("cpuField").value == "")
                        {
                           // urlForward = "CPUSystemPage.jsp?cod="+document.getElementById("temp").value+"&priceField="+document.getElementById("priceField").value;
                        }
                        else
                        {
                           // urlForward = RAMSystem
                        }
                          
                    urlBackward = "MBSystemPage.jsp";
                    //urlBackward = "MBSystemPage.jsp?cod=" + document.getElementById("temp").value + "&priceField="+ document.getElementById("cpuPrice").value;
                    var cpuIndex;
                    var tableCPU = document.getElementById("table2");
                    // get selected row
                    // display selected row data in text input        
                    for(var i = 1; i < tableCPU.rows.length; i++)
                    {
                        tableCPU.rows[i].onclick = function()
                        {
                            //Remove the previous selected row
                            if (typeof cpuIndex !== "undefined"){
                                tableCPU.rows[cpuIndex].classList.toggle("selected");
                            }
                            //Get the selected row index
                            cpuIndex = this.rowIndex;
                            //Add class to the selected row
                            this.classList.toggle("selected");
                            
                            document.getElementById("cpuField").value = this.cells[0].innerHTML + " " + this.cells[1].innerHTML;
                            document.getElementById("cpuCod").value = this.cells[7].innerHTML;
                            document.getElementById("priceField").value = (parseFloat(document.getElementById("cpuPrice").value) + parseFloat(this.cells[6].innerHTML)).toFixed(2);
                            document.getElementById("price").value = document.getElementById("priceField").value;
                            document.getElementById("nextbtn").disabled = false;
                            
                            document.cookie = "CPUCOD="+document.getElementById("cpuCod").value;
                           document.cookie = "PRICE="+document.getElementById("price").value;
                            //urlForward="RAMSystemPage.jsp?mbcod="+ document.getElementById("temp").value +"&cpucod=" + this.cells[7].innerHTML +"&priceField="+ document.getElementById("priceField").value;
                        };
                    }
                </script>
                <form action="RAMSystemPage.jsp" method="POST">
                    <input type="hidden" id="cpuCod" name ="cpuCod" value="<% if(cpucod!=null) out.print(cpucod); %>"/>
                    <input type="hidden" id="price" name ="price" value="<% if(price!=null) out.print(price); %>"/>
                    <input type="submit" disabled="" id="nextbtn" value="Next"/>
                </form>
                <a href="javascript:history.go(-1)" onMouseOver="self.status.referrer; return true;"><input type="button" class="btnPrev" value="Previous"></a>
                <!--input  type="button" value="Previous" name="previous" onclick="location.href=urlBackward"/-->
                <!--input  type="button" value="Next" name="next" onclick="location.href=urlForward"/-->
            </div>
            <div class="footer">
                    <input type="button" value="Admin_Mode" name="Admin_Mode" onclick="location.href='../../AdminPanel/Login.html'"/>
                    <input type="button" value="Restart" name="RestartConfig" onclick="location.href='../../index.html'"/>
            </div>
        </div>
    </body>
</html>
