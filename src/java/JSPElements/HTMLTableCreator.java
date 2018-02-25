package JSPElements;
import Components.CPULoader;
import Components.CaseLoader;
import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.PSLoader;
import Components.RAMLoader;
import DatabaseElements.DBComponentController;
import DatabaseElements.DBFilters;
import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import Exceptions.NoCPUMatchedException;
import Exceptions.NoRAMMatchedException;
import java.sql.SQLException;

public class HTMLTableCreator {
    public static String createMotherboard(Boolean f) throws SQLException
    {
        String output;
        StringBuilder ss = new StringBuilder();
        try{
            DBComponentController db = new DBComponentController();
            MBLoader mb = db.loadMB();

            ss.append("<table id=\"table1\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th onclick=\"sortTable(0)\">Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Socket</th>");
            ss.append("<th>Formfactor</th>");
            ss.append("<th>Chipset</th>");
            ss.append("<th>RAM Slots</th>");
            ss.append("<th>RAM Type</th>");
            ss.append("<th>RAM Capacity</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th onclick=\"sortTable(9)\">Price</th>");
            if(f == true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");
        
            for(int i = 0; i < mb.getMBSize(); i++)
            {
                int cod = mb.listCods().get(i);
                String str1 = mb.listBrands().get(i);
                String str2 = mb.listModels().get(i);
                String str3 = mb.listSockets().get(i);
                String str4 = mb.listFormfactors().get(i);
                String str5 = mb.listChipsets().get(i);
                Integer int1 = mb.listramslots().get(i);
                String str6 = mb.listRamTypes().get(i);
                Integer int2 = mb.listmaxrams().get(i);
                Integer int3 = mb.listTDPs().get(i);
                Double dub1 = mb.listPrices().get(i);

                ss.append("<tr>");

                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+str5+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+str6+"</td>");
                ss.append("<td>"+int2+"</td>");
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
            db.closeall();
        }
        catch(ComponentLoadingException cle)
        {
            ss.append(cle.getMessage());
        }

        output = ss.toString();
        return output;
    }

    public static String createCPU(Boolean f, Boolean status, String brand, String model)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{                           
            //per avere qualcosa del tipo new DBCetc().loadetc(); chiudo la connessione in ogni metodo load
            DBComponentController dbc = new DBComponentController();
            DBFilters db = new DBFilters();
            CPULoader cpu = new CPULoader();

            //se f è vera, allora siamo nel lato Admin e non c'è necessità di compatibilità
            if(f == true) cpu = dbc.loadCPU();
            //se f è falsa, allora siamo nel caso Customer
            //e in base al vincolo o meno status sarà true o false
            if(f == false)
            {
                if(status == true) cpu = db.filterCPU(brand,model);
                if(status == false) cpu = dbc.loadCPU();
            }


            ss.append("<table id=\"table2\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Socket</th>");
            ss.append("<th>Frequency</th>");
            ss.append("<th>Cores</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < cpu.getSize(); i++)
            {
                int cod = cpu.listCods().get(i);
                String str1 = cpu.listBrands().get(i);
                String str2 = cpu.listModels().get(i);
                String str3 = cpu.listSockets().get(i);
                Double db1 = cpu.listFrequencies().get(i);
                Integer int1 = cpu.listCores().get(i);
                Integer int2 = cpu.listTDPs().get(i);
                Double db2 = cpu.listPrices().get(i);

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
                db.closeall();
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
        output = ss.toString();
                                   
        return output;
    }
    
    public static String createRAM(Boolean f, Boolean status, String brand, String model)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{     
            DBComponentController dbc = new DBComponentController();
            DBFilters db = new DBFilters();
            RAMLoader ram = new RAMLoader();


            //se f è vera, allora siamo nel lato Admin e non c'è necessità di compatibilità
            if(f == true) ram = dbc.loadRAM();
            //se f è falsa, allora siamo nel caso Customer
            //e in base al vincolo o meno status sarà true o false
            if(f == false)
            {
                if(status == true) ram = db.filterRAM(brand,model);
                if(status == false) ram = dbc.loadRAM();
            }


            ss.append("<table id=\"table3\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Ram Type</th>");
            ss.append("<th>Speed</th>");
            ss.append("<th>TDP</th>");	
            ss.append("<th>Modules</th>");
            ss.append("<th>Modules Size</th>");
            ss.append("<th>Size</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");


            for(int i = 0; i < ram.getSize(); i++)
            {
                int cod = ram.listCods().get(i);

                String str1 = ram.listBrands().get(i);
                String str2 = ram.listModels().get(i);
                String str3 = ram.listTypes().get(i);
                String str4 = ram.listSpeeds().get(i);
                Integer int1 = ram.listTDPs().get(i);
                Integer int2 = ram.listNOMs().get(i);
                Integer int3 = ram.listSOMs().get(i);
                Integer int4 = ram.listSizes().get(i);
                Double db1 = ram.listPrices().get(i);

                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+int1+"</td>");
                ss.append("<td>"+int2+"</td>");
                ss.append("<td>"+int3+"</td>");
                ss.append("<td>"+int4+"</td>");
                ss.append("<td>"+db1+"</td>");
                if(f==true) ss.append("<td> <form action=\"../DeletePage/DeleteRam.jsp\" method=\"post\"> <input type=\"hidden\" value=\" " + cod + " \" name = \"deletecod\"> <input type=\"submit\" value=\"Remove\"> </form action> </td>");
                ss.append("<td");
                if(f == false) ss.append(" style=\"display:none;\"");
                ss.append(">"+cod+"</td>");
                ss.append("</tr>");

            }

            db.closeall();
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
        output = ss.toString();
                                   
        return output;
    }
    
    
    public static String createGCard(Boolean f)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{
        
            DBComponentController dbc = new DBComponentController();
            GCardLoader gc = new GCardLoader();

            gc = dbc.loadGCard();

            ss.append("<table id=\"table4\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Chipset</th>");
            ss.append("<th>Memory</th>");
            ss.append("<th>Core Clock</th>");
            ss.append("<th>TDP</th>");	
            ss.append("<th>Length</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < gc.getSize(); i++)
            {
                int cod = gc.listCods().get(i);
                String str1 = gc.listBrands().get(i);
                String str2 = gc.listModels().get(i);
                String str3 = gc.listSeries().get(i);
                String str4 = gc.listChipsets().get(i);
                Integer int1 = gc.listMemory().get(i);
                Double db1 = gc.listClocks().get(i);
                Integer int2 = gc.listTDPs().get(i);
                Integer int3 = gc.listLength().get(i);
                Double db2 = gc.listPrices().get(i);
                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+int1+"</td>");
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
            dbc.closeall();
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
    
    
    public static String createHDrive(Boolean f)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{
            
            DBComponentController db = new DBComponentController();
            HDriveLoader hd = db.loadHDrive();

            ss.append("<table id=\"table5\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Form</th>");
            ss.append("<th>Type</th>");
            ss.append("<th>Size</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th>Cache</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < hd.getSize(); i++)
            {
                int cod = hd.listCods().get(i);
                String str1 = hd.listBrands().get(i);
                String str2 = hd.listModels().get(i);
                String str3 = hd.listSeries().get(i);
                String str4 = hd.listForms().get(i);
                String str5 = hd.listTypes().get(i);				
                Integer int1 = hd.listSizes().get(i);
                Integer int2 = hd.listTDPs().get(i);
                Integer int3 = hd.listCaches().get(i); 
                Double db1 = hd.listPrices().get(i);
                ss.append("<tr>");
                ss.append("<td>"+str1+"</td>");
                ss.append("<td>"+str2+"</td>");
                ss.append("<td>"+str3+"</td>");
                ss.append("<td>"+str4+"</td>");
                ss.append("<td>"+str5+"</td>");
                ss.append("<td>"+int1+"</td>");
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
            db.closeall();
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
    
    public static String createPS(Boolean f)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{
            DBComponentController db = new DBComponentController();
            PSLoader ps = db.loadPS();

            ss.append("<table id=\"table6\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Series</th>");
            ss.append("<th>Form</th>");
            ss.append("<th>Efficiency</th>");
            ss.append("<th>TDP</th>");
            ss.append("<th>Modular</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < ps.getSize(); i++)
            {
                int cod = ps.listCods().get(i);
                String str1 = ps.listBrands().get(i);
                String str2 = ps.listModels().get(i);
                String str3 = ps.listSeries().get(i);
                String str4 = ps.listForms().get(i);
                String str5 = ps.listEfficiencies().get(i);
                Integer int1 = ps.listMaxTDPs().get(i);
                String str6 = ps.listModulars().get(i);
                Double db1 = ps.listPrices().get(i);

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
            ss.append("</tbody>");
            ss.append("</table>");
            db.closeall();
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
    
    
    public static String createCase(Boolean f)
    {
        String output;
        StringBuilder ss = new StringBuilder();
        
        try{
            DBComponentController db = new DBComponentController();
            CaseLoader ca = db.loadCase();

            ss.append("<table id=\"table7\" class=\"tableSection\">");
            ss.append("<thead>");
            ss.append("<tr>");
            ss.append("<th>Brand</th>");
            ss.append("<th>Model</th>");
            ss.append("<th>Type</th>");
            ss.append("<th>Color</th>");
            ss.append("<th>Compatibility</th>");
            ss.append("<th>Length Max</th>");
            ss.append("<th>Price</th>");
            if(f==true) ss.append("<th>Delete</th>");
            ss.append("<th");
            if(f == false) ss.append(" style=\"display:none;\"");
            ss.append(">COD</th>");
            ss.append("</tr>");
            ss.append("</thead>");
            ss.append("<tbody>");

            for(int i = 0; i < ca.getSize(); i++)
            {
                int cod = ca.listCods().get(i);
                String str1 = ca.listBrands().get(i);
                String str2 = ca.listModels().get(i);
                String str3 = ca.listTypes().get(i);
                String str4 = ca.listColors().get(i);
                String str5 = ca.listMB_Comp().get(i);
                Double db1 = ca.listMax_hd_Len().get(i);
                Double db2 = ca.listPrices().get(i);

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
            db.closeall();
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
