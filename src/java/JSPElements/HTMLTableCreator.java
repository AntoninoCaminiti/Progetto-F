package JSPElements;
import Components.CPU;
import Components.PCCase;
import Components.GraphicsCard;
import Components.MemoryDrive;
import Components.Motherboard;
import Components.PowerSupply;
import Components.RAM;
import Components.TDPConstraint;
import Components.UserCart;
import DatabaseElements.DBComponentController;
import DatabaseElements.DBFilters;
import Exceptions.ComponentLoadingException;
import Exceptions.NoCPUMatchedException;
import Exceptions.NoRAMMatchedException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HTMLTableCreator {
    
    private static UserCart uc = null;
    
    
    public HTMLTableCreator()
    {
        
    }
    
    public HTMLTableCreator(UserCart uc)
    {
        this.uc = uc;
    }
    
     /**
     * Create motherboard table containing data
     * @param f boolean if true print admin content, if false print customer content
     * @throws SQLException in case an SQL exception is occurred
     * @return motherboard table
     */
    public static String createMotherboard(Boolean f) throws SQLException
    {
        String output;
        StringBuilder ss = new StringBuilder();
        try{
            DBComponentController db = new DBComponentController();
            ArrayList <Motherboard> motherboardArr = db.loadMB();

            ss.append("<table id=\"table1\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Socket</th>");
            ss.append("<th>Formfactor</th>");
            ss.append("<th>Chipset</th>");
            ss.append("<th>RAM Slots</th>");
            ss.append("<th>RAM Type</th>");
            ss.append("<th onclick=\"sortTable(7)\">RAM Capacity</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th onclick=\"sortNumber(9)\">Price</th>");
            if(f == true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");
        
            for(int i = 0; i < motherboardArr.size(); i++)
            {
                int cod = motherboardArr.get(i).getCod();
                String str1 = motherboardArr.get(i).getBrand();
                String str2 = motherboardArr.get(i).getModel();
                String str3 = motherboardArr.get(i).getSocket();
                String str4 = motherboardArr.get(i).getFormfactor();
                String str5 = motherboardArr.get(i).getChipset();
                Integer int1 = motherboardArr.get(i).getRamSlot();
                String str6 = motherboardArr.get(i).getRamType();
                Integer int2 = motherboardArr.get(i).getMaxRamSupported();
                Integer int3 = motherboardArr.get(i).getTdp();
                Double dub1 = motherboardArr.get(i).getPrice();

                ss.append("<tr>");

                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+str5+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+str6+"</td>");
                ss.append("<td>"+int2+ "GB" +"</td>");
                ss.append("<td>"+int3+"</td>");
                ss.append("<td>"+dub1+"</td>");
                if(f == true) ss.append("<td> <form action=\"../DeletePage/DeleteMotherboard.jsp\" method=\"post\"><input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");

            }		

            ss.append("</tbody>");
            ss.append("</table>");
            ss.append(TableSorter.sortTable("table1"));
            ss.append(TableSorter.sortTablePrice("table1"));
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }

        output = ss.toString();
        return output;
    }

    /**
     * Create cpu table contaning either filtered or unfiltered data
     * @param f if true print admin content, if false print customer content
     * @param status status of constraint, if true filter the table based on compatibility otherwise print all CPUs
     * @param brand brand of cpu component
     * @param model model of cpu component
     * @return the cpu table
     */
    public static String createCPU(Boolean f, Boolean status, String brand, String model)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{                           
            //per avere qualcosa del tipo new DBCetc().loadetc(); chiudo la connessione in ogni metodo load
            DBComponentController dbc = new DBComponentController();
            DBFilters db = new DBFilters();
            ArrayList <CPU> cpupc = new ArrayList<>();
            
            //se f è vera, allora siamo nel lato Admin e non c'è necessità di compatibilità
            if(f == true) cpupc = dbc.loadCPU();
            //se f è falsa, allora siamo nel caso Customer
            //e in base al vincolo o meno status sarà true o false
            if(f == false)
            {
                if(status == true) cpupc = db.filterCPU(brand,model);
                if(status == false) cpupc = dbc.loadCPU();
            }


            ss.append("<table id=\"table2\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Socket</th>");
            ss.append("<th onclick=\"sortTable(3)\">Frequency</th>");
            ss.append("<th onclick=\"sortTable(4)\">Cores</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th onclick=\"sortNumber(6)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < cpupc.size(); i++)
            {
                int cod = cpupc.get(i).getCod();
                String str1 = cpupc.get(i).getBrand();
                String str2 = cpupc.get(i).getModel();
                String str3 = cpupc.get(i).getSocket();
                Double db1 = cpupc.get(i).getClockSpeed();
                Integer int1 = cpupc.get(i).getCore();
                Integer int2 = cpupc.get(i).getTdp();
                Double db2 = cpupc.get(i).getPrice();

                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+db1+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+db2+"</td>");
                if(f == true) ss.append("<td> <form action=\"../DeletePage/DeleteCpu.jsp\" method=\"post\"><input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");
                 }
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(NoCPUMatchedException nce)
        {
            ss.append(nce.getMessage());
            
        }
        catch(SQLException ex){
            ss.append(ex.getMessage());
        }	
        ss.append("</tbody>");
        ss.append("</table>");
        ss.append(TableSorter.sortTable("table2"));
        ss.append(TableSorter.sortTablePrice("table2"));
        output = ss.toString();
                                   
        return output;
    }
    
    public static String createCPU(Boolean f, Boolean status, int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        ComponentParser cp = new ComponentParser();
        
        
        try{                           
            //per avere qualcosa del tipo new DBCetc().loadetc(); chiudo la connessione in ogni metodo load
            DBComponentController dbc = new DBComponentController();
            DBFilters db = new DBFilters();
            ArrayList <CPU> cpupc = new ArrayList<>();
            uc.setMotherboard((Motherboard) cp.getComponent(prevcod));
            //se f è vera, allora siamo nel lato Admin e non c'è necessità di compatibilità
            if(f == true) cpupc = dbc.loadCPU();
            //se f è falsa, allora siamo nel caso Customer
            //e in base al vincolo o meno status sarà true o false
            if(f == false)
            {
                if(status == true) cpupc = db.filterCPU(String.valueOf(prevcod));
                if(status == false) cpupc = dbc.loadCPU();
            }


            ss.append("<table id=\"table2\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Socket</th>");
            ss.append("<th onclick=\"sortTable(3)\">Frequency</th>");
            ss.append("<th onclick=\"sortTable(4)\">Cores</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th onclick=\"sortNumber(6)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < cpupc.size(); i++)
            {
                int cod = cpupc.get(i).getCod();
                String str1 = cpupc.get(i).getBrand();
                String str2 = cpupc.get(i).getModel();
                String str3 = cpupc.get(i).getSocket();
                Double db1 = cpupc.get(i).getClockSpeed();
                Integer int1 = cpupc.get(i).getCore();
                Integer int2 = cpupc.get(i).getTdp();
                Double db2 = cpupc.get(i).getPrice();

                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+db1+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+db2+"</td>");
                if(f == true) ss.append("<td> <form action=\"../DeletePage/DeleteCpu.jsp\" method=\"post\"><input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");
                 }
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(NoCPUMatchedException nce)
        {
            ss.append(nce.getMessage());
            
        }
        catch(SQLException ex){
            ss.append(ex.getMessage());
        }	
        ss.append("</tbody>");
        ss.append("</table>");
        ss.append(TableSorter.sortTable("table2"));
        ss.append(TableSorter.sortTablePrice("table2"));
        output = ss.toString();
                                   
        return output;
    }
    
        
    /**
     * Create ram table compatible with the motherboard component
     * @param f boolean if true print admin content, if false print customer content
     * @param status status of constraint, if true filter the table based on compatibility otherwise print all RAMs
     * @param brand the brand of ram component
     * @param model the model of ram component
     * @return the ram table
     */
    public static String createRAM(Boolean f, Boolean status, int filCod,int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{     
            DBComponentController dbc = new DBComponentController();
            DBFilters db = new DBFilters();
            ArrayList <RAM> ramar = new ArrayList<>();
            ComponentParser cp = new ComponentParser();

            uc.setCpupc((CPU) cp.getComponent(prevcod));
            
            //se f è vera, allora siamo nel lato Admin e non c'è necessità di compatibilità
            if(f == true) ramar = dbc.loadRAM();
            //se f è falsa, allora siamo nel caso Customer
            //e in base al vincolo o meno status sarà true o false
            if(f == false)
            {
                if(status == true) ramar = db.filterRAM(String.valueOf(filCod));
                if(status == false) ramar = dbc.loadRAM();
            }


            ss.append("<table id=\"table3\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>DIMM Type</th>");
            ss.append("<th>Type</th>");
            ss.append("<th>TDP</th>");	
            ss.append("<th>Modules</th>");
            ss.append("<th onclick=\"sortNumber(6)\">Modules Size</th>");
            ss.append("<th onclick=\"sortNumber(7)\">Size</th>");
            ss.append("<th onclick=\"sortNumber(8)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");


            for(int i = 0; i < ramar.size(); i++)
            {
                int cod = ramar.get(i).getCod();
                String str1 = ramar.get(i).getBrand();
                String str2 = ramar.get(i).getModel();
                String str3 = ramar.get(i).getType();
                String str4 = ramar.get(i).getClockSpeed();
                Integer int1 = ramar.get(i).getTdp();
                Integer int2 = ramar.get(i).getNumberOfModules();
                Integer int3 = ramar.get(i).getSizeOfModules();
                Integer int4 = ramar.get(i).getTotalSize();
                Double db1 = ramar.get(i).getPrice();

                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+int3+ "GB" +"</td>");
                ss.append("<td>"+int4 + "GB" +"</td>");
                ss.append("<td>"+db1+"</td>");
                if(f==true) ss.append("<td> <form action=\"../DeletePage/DeleteRam.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");

            }

        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(NoRAMMatchedException nrm)
        {
            ss.append(nrm.getMessage());
        }
        catch(SQLException ex){
            ss.append(ex.getMessage());
        }	
        ss.append("</tbody>");
        ss.append("</table>");
        ss.append(TableSorter.sortTable("table3"));
        ss.append(TableSorter.sortTablePrice("table3"));
        output = ss.toString();
                                   
        return output;
    }
    
    
    /**
     * Create Graphics Card table
     * @param f boolean if true print admin content, if false print customer content
     * @return the Graphics Card table
     */
    public static String createGCard(Boolean f, int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        ComponentParser cp = new ComponentParser();
        
        try{
        
            DBComponentController dbc = new DBComponentController();
            ArrayList <GraphicsCard> graphics = dbc.loadGCard();
            uc.setMemoryram((RAM) cp.getComponent(prevcod));
            ss.append("<table id=\"table4\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Chipset</th>");
            ss.append("<th onclick=\"sortNumber(4)\">Memory</th>");
            ss.append("<th>Core Clock</th>");
            ss.append("<th>TDP</th>");	
            ss.append("<th>Length</th>");
            ss.append("<th onclick=\"sortNumber(8)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < graphics.size(); i++)
            {
                int cod = graphics.get(i).getCod();
                String str1 = graphics.get(i).getBrand();
                String str2 = graphics.get(i).getModel();
                String str3 = graphics.get(i).getSerie();
                String str4 = graphics.get(i).getChipset();
                Integer int1 = graphics.get(i).getMemory();
                Double db1 = graphics.get(i).getClockSpeed();
                Integer int2 = graphics.get(i).getTdp();
                Integer int3 = graphics.get(i).getWidth();
                Double db2 = graphics.get(i).getPrice();
                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+int1+ "GB"+"</td>");
                ss.append("<td>"+db1+"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+int3+"</td>");
                ss.append("<td>"+db2+"</td>");
                if(f==true) ss.append("<td> <form action=\"../DeletePage/DeleteGCard.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");

            }
            ss.append("</tbody>");
            ss.append("</table>");
            ss.append(TableSorter.sortTable("table4"));
            ss.append(TableSorter.sortTablePrice("table4"));
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(SQLException ex){
            ss.append(ex.getMessage());
        }
        
        output = ss.toString();
        
        return output;
    }
    /**
     * Create the Hard Drive table
     * @param f boolean if true print admin content, if false print customer content
     * @return the Hard Drive table
     */
    public static String createHDrive(Boolean f, int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        ComponentParser cp = new ComponentParser();
        try{
            
            DBComponentController db = new DBComponentController();
            ArrayList <MemoryDrive> memDrive = db.loadMDrive();
            uc.setGraphics((GraphicsCard) cp.getComponent(prevcod));
            ss.append("<table id=\"table5\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Form</th>");
            ss.append("<th>Type</th>");
            ss.append("<th onclick=\"sortNumber(5)\">Size</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th>Cache</th>");
            ss.append("<th onclick=\"sortNumber(8)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < memDrive.size(); i++)
            {
                int cod = memDrive.get(i).getCod();
                String str1 = memDrive.get(i).getBrand();
                String str2 = memDrive.get(i).getModel();
                String str3 = memDrive.get(i).getSerie();
                String str4 = memDrive.get(i).getForm();
                String str5 = memDrive.get(i).getType();
                Integer int1 = memDrive.get(i).getSize();
                Integer int2 = memDrive.get(i).getTdp();
                Integer int3 = memDrive.get(i).getCache();
                Double db1 = memDrive.get(i).getPrice();
                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+str5+"</td>");
                ss.append("<td>"+int1+ "GB" +"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+int3+"</td>");
                ss.append("<td>"+db1+"</td>");
                if(f == true) ss.append("<td> <form action=\"../DeletePage/DeleteHDisk.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");
            }		
            ss.append("</tbody>");
            ss.append("</table>");
            ss.append(TableSorter.sortTable("table5"));
            ss.append(TableSorter.sortTablePrice("table5"));
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(SQLException ex){
            ss.append(ex.getMessage());
        }
        
        output = ss.toString();
        
        return output;
    }
    
    /**
     * Create Power Supply table
     * @param f boolean if true print admin content, if false print customer content
     * @return the Power Supply table
     */
    public static String createPS(Boolean f, int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        ComponentParser cp = new ComponentParser();
        try{
            DBComponentController db = new DBComponentController();
            ArrayList <PowerSupply> power_supp = db.loadPS();
            TDPConstraint cs = new TDPConstraint();
            
            uc.setMemdrive((MemoryDrive) cp.getComponent(prevcod));
            int threshold = uc.getTotalTDP();
            ss.append("<table id=\"table6\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Form</th>");
            ss.append("<th>Efficiency</th>");
            ss.append("<th onclick=\"sortNumber(5)\">TDP</th>");
            ss.append("<th>Modular</th>");
            ss.append("<th onclick=\"sortNumber(7)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < power_supp.size(); i++)
            {
                int cod = power_supp.get(i).getCod();
                String str1 = power_supp.get(i).getBrand();
                String str2 = power_supp.get(i).getModel();
                String str3 = power_supp.get(i).getSerie();
                String str4 = power_supp.get(i).getForm();
                String str5 = power_supp.get(i).getEfficiency();
                Integer int1 = power_supp.get(i).getMaxTDPSupported();
                String str6 = power_supp.get(i).getModular();
                Double db1 = power_supp.get(i).getPrice();
                
                uc.setPowersupp((PowerSupply) cp.getComponent(cod));
                
                if(cs.isCompatible(uc))
                {
                    ss.append("<tr>");
                    ss.append("<td>"+str1+"</td>");
                    ss.append("<td>"+str2+"</td>");
                    ss.append("<td>"+str3+"</td>");
                    ss.append("<td>"+str4+"</td>");
                    ss.append("<td>"+str5+"</td>");
                    ss.append("<td>"+int1+"</td>");
                    ss.append("<td>"+str6+"</td>");
                    ss.append("<td>"+db1+"</td>");
                    if(f == true) ss.append("<td> <form action=\"../DeletePage/DeletePS.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                    ss.append("<td");
                    if(f == false) ss.append(" style=\"display:none;\"");
                    ss.append(">"+cod+"</td>");
                    ss.append("</tr>");
                }
            }		
            ss.append("</tbody>");
            ss.append("</table>");
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(SQLException ex){
        ss.append(ex.getMessage());
        }
        
        ss.append(TableSorter.sortTable("table6"));
        ss.append(TableSorter.sortTablePrice("table6"));
        output = ss.toString();
        
        return output;
    }
    
    /**
     * Create case table
     * @param f boolean if true print admin content, if false print customer content
     * @return the case table
     */
    public static String createCase(Boolean f, int prevcod)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        ComponentParser cp = new ComponentParser();
        
        try{
            DBComponentController db = new DBComponentController();
            ArrayList <PCCase> caseesac = db.loadCase();
            uc.setPowersupp((PowerSupply) cp.getComponent(prevcod));
            
            ss.append("<table id=\"table7\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th onclick=\"sortTable(1)\">Model</th>");
            ss.append("<th>Type</th>");
            ss.append("<th>Color</th>");
            ss.append("<th>Compatibility</th>");
            ss.append("<th onclick=\"sortNumber(5)\">Length Max</th>");
            ss.append("<th onclick=\"sortNumber(6)\">Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < caseesac.size(); i++)
            {
                int cod = caseesac.get(i).getCod();
                String str1 = caseesac.get(i).getBrand();
                String str2 = caseesac.get(i).getModel();
                String str3 = caseesac.get(i).getType();
                String str4 = caseesac.get(i).getColor();
                String str5 = caseesac.get(i).getCompatibleMBs();
                Double db1 = caseesac.get(i).getHdLengthSupported();
                Double db2 = caseesac.get(i).getPrice();

                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+str5+"</td>");
                ss.append("<td>"+db1+"</td>");
                ss.append("<td>"+db2+"</td>");
                if(f == true) ss.append("<td> <form action=\"../DeletePage/DeleteCase.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");
            }		
            ss.append("</tbody>");
            ss.append("</table>");
            ss.append(TableSorter.sortTable("table7"));
            ss.append(TableSorter.sortTablePrice("table7"));
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }
        catch(SQLException ex){
        ss.append(ex.getMessage());
        }
        
        output = ss.toString();
        
        return output;
    }

}
