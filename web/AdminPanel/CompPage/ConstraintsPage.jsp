<%@ page language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="JSPElements.*"%>
<%@ page import="DatabaseElements.*"%>

<%@ page contentType="te3xt7htarset=ISO-8859-5" %>

<%
    //
    String inputCPUtype = "";
    String inputRAMtype = "";
    String submit = "";
    
    try
    {
        if(new DBUserHandler().getCPUStatusConstr() == true) 
        {
            inputCPUtype = "checked";
        }
        if(new DBUserHandler().getCPUStatusConstr() == false)
        {
            inputCPUtype = "unchecked";
        }
        if(new DBUserHandler().getRAMStatusConstr() == true) 
        {
            inputRAMtype = "checked";
        }
        if(new DBUserHandler().getRAMStatusConstr() == false)
        {
            inputRAMtype = "unchecked";
        }
    }
    catch(SQLException e)
    {
        out.println("<html> <body> " + e + " </html> </body>");
    }
    
%>

<html>
    <head>
	<title> ADMIN MODE </title>
	<link rel="stylesheet" href="../../CSStyles/ConstraintsAdminStyle.css">
        <link rel="icon" href="./../../CSStyles/projectIcon.png" type="image/png"/>
    </head>
    <body>
        <div class="grid">
            <a href="MotherboardPage.jsp"></a>
            <div class="header"><h1> Admin Side - Choose Type of Component </h1>
            <%//Success of login
            if ((session.getAttribute("useridadm") == null) || (session.getAttribute("useridadm") == "")) {
                response.sendRedirect("../../indexadmin.jsp"); 
            } else { %>
                Welcome <%=session.getAttribute("useridadm")%> <a href='../../logout.jsp'>Log out</a>
            <%}%>
            </div>
            <div class="navbar">
                <input type="button" class="btn" value="Motherboard" name="motherboard" onclick="location.href='MotherboardPage.jsp'"/>
                <input type="button" class="btn" value="CPU" name="cpu" onclick="location.href='CpuPage.jsp'"/>
                <input type="button" class="btn" value="RAM" name="ram" onclick="location.href='RamPage.jsp'"/>
                <input type="button" class="btn" value="Graphics Card" name="gcard" onclick="location.href='GCardPage.jsp'"/>
                <input type="button" class="btn" value="Hard Disk" name="hdisk" onclick="location.href='HDiskPage.jsp'"/>
                <input type="button" class="btn" value="Power Supply" name="powersupply" onclick="location.href='PowerSupplyPage.jsp'"/>
                <input type="button" class="btn" value="Case" name="case" onclick="location.href='CasePage.jsp'"/>
                <input type="button" class="btn" value="Constraints" name="constraints" onclick="location.href='ConstraintsPage.jsp'"/>
            </div>
            <div class="content">
                <center>
                    <h1>Tick which constraint want to set:</h1>
                    <form action="../AddPage/EditConstraints.jsp" method="POST">
                        <input type ="hidden" id="cpustatus" name="cpustatus" />
                        <input type ="hidden" id="ramstatus" name="ramstatus" />
                        <p>
                            <input type="checkbox" onclick="setCPU()" id="CPUFlag" name="CPUFlag" value="" <% out.print(inputCPUtype); %>>CPU Filtering</input>
                        </p>
                        <p>
                            <input type="checkbox" onclick="setRAM()" id="RAMFlag" name="RAMFlag" value="" <% out.print(inputRAMtype); %>>RAM Filtering</input>
                        </p>
                        <p>
                            <input type="submit" class="btn" value="Update"/>
                        </p>
                    </form>
                </center>
            </div>
            <div class="insidebar"></div>
            <div class="footer"></div>
	</div>
    </body>
</html>

<script>
    function isnum(error) {

    if (isNaN(error.value) || parseInt(error.value)<0.0 || parseInt(error.value) > 9999.99999){
        alert("Nel campo e' possibile immettere solo numeri!");
        error.value="";
        error.focus();
    }

    }
    
   function setCPU(){
    if(document.getElementById("CPUFlag").checked==true) document.getElementById("cpustatus").value = "true";
    if(document.getElementById("CPUFlag").checked==false) document.getElementById("cpustatus").value = "false";
    }
   function setRAM(){
    if(document.getElementById("RAMFlag").checked==true) document.getElementById("ramstatus").value = "true";
    if(document.getElementById("RAMFlag").checked==false) document.getElementById("ramstatus").value = "false";
    }

</script>