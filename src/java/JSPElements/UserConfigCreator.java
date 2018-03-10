package JSPElements;

import Components.*;
import Components.UserConfigurations;
import DatabaseElements.DBConnection;
import Exceptions.ComponentLoadingException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author EugeHysa
 */
public class UserConfigCreator {
    
    private Connection conn = null;
    private Statement mystmt = null;
    private ResultSet res = null;
    
  /**
   * Constructor for UserConfigCreator, which gets connection from DBConnection class
   * @throws SQLException if an SQL Exception is occurred 
   */
    public UserConfigCreator() throws SQLException
    {
        DBConnection connection = new DBConnection();
        conn = connection.Connect();
        mystmt = conn.createStatement();
    }
        
    /**
     * Create the saved buildings table, parsing all information (components info and total price) for a single save
     * @param userid the username for the customer
     * @return output prints the html converted table that contains the building information
     * @throws SQLException if an SQL exception is occured 
     */  
    public String createTable(String userid) throws SQLException, ComponentLoadingException
    {
        String output;
        StringBuilder sb = new StringBuilder();
        UserConfigurations ucs = new UserConfigurations(userid);
        Constraints c1;
        /*Inserimento building nella tabella*/
        res = mystmt.executeQuery("select save.MCOD, save.CPUCOD, save.RCOD, save.GCOD, save.HCOD, save.PCOD, save.CSCOD from CustomerLogin join (select pur.MCOD, pur.CPUCOD, pur.RCOD, pur.GCOD, pur.HCOD, pur.PCOD, pur.CSCOD, sa.SAVECOD from SAVES as sa join PURCHASES as pur where sa.PURCOD = pur.COD) as save where save.SAVECOD = CustomerLogin.USERSAVE and USERNAME = '"+ userid +"' ");
        while(res.next())
        {
            Motherboard tmpmb = (Motherboard) new ComponentParser().getComponent(res.getInt(1));
            CPU tmpcpu = (CPU) new ComponentParser().getComponent(res.getInt(2));
            RAM tmpram = (RAM) new ComponentParser().getComponent(res.getInt(3));
            GraphicsCard tmpgc = (GraphicsCard) new ComponentParser().getComponent(res.getInt(4));
            MemoryDrive tmpmd = (MemoryDrive) new ComponentParser().getComponent(res.getInt(5));
            PowerSupply tmpps = (PowerSupply) new ComponentParser().getComponent(res.getInt(6));
            PCCase tmpcc = (PCCase) new ComponentParser().getComponent(res.getInt(7));
            ucs.addSavedConfiguration(tmpmb, tmpcpu, tmpram, tmpgc, tmpmd, tmpps, tmpcc);
        }
        conn.close();
        mystmt.close();
        res.close();
        /*Tabella intestazione*/
        sb.append("<table id=\"tableBuild\" class=\"tableSection\">");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th>Motherboard</th>");
        sb.append("<th>Cpu</th>");
        sb.append("<th>Ram</th>");
        sb.append("<th>Graphic Card</th>");
        sb.append("<th>Hard Disk</th>");
        sb.append("<th>Power Supply</th>");
        sb.append("<th>Case</th>");
        sb.append("<th>Price</th>");
        sb.append("</tr>");
        sb.append("</thead>");
        /*Tabella contenuto*/
        sb.append("<tbody>");
        for(int i = 0; i < ucs.getNumberOfConfs(); i++)
        {
            sb.append("<tr>");
            sb.append("<td>"+ucs.getSave().get(i).getMotherboard().getBrand() + " " + ucs.getSave().get(i).getMotherboard().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getCpupc().getBrand() + " " + ucs.getSave().get(i).getCpupc().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getMemoryram().getBrand() + " " + ucs.getSave().get(i).getMemoryram().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getGraphics().getBrand() + " " + ucs.getSave().get(i).getGraphics().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getMemdrive().getBrand() + " " + ucs.getSave().get(i).getMemdrive().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getPowersupp().getBrand() + " " + ucs.getSave().get(i).getPowersupp().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getCasesac().getBrand() + " " + ucs.getSave().get(i).getCasesac().getModel() +"</td>");
            sb.append("<td>"+ucs.getSave().get(i).getTotPrice()+"</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>"); 
        output = sb.toString();
        
        return output;
    }
    
}
