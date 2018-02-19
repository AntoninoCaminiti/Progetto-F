package JSPElements;

import DatabaseElements.DBConnection;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author EugeHysa
 */
public class UserConfigCreator extends DBConnection {
    Connection conn = null;
                    Statement mystmt = null;
                    ResultSet res = null;
    
    public UserConfigCreator() throws SQLException
    {
        mystmt = this.Connect();
    }
        
        
    public String createTable(String userid) throws SQLException
    {
        String output = " ";
        StringBuilder sb = new StringBuilder();
         
                    ArrayList componentsCods = new ArrayList();
                    /*Inserimento building nella tabella*/

                        
                        /**/
                        //String userid = (String) request.getSession().getAttribute("userid");
                        res = mystmt.executeQuery("select save.MCOD, save.CPUCOD, save.RCOD, save.GCOD, save.HCOD, save.PCOD, save.CSCOD from CustomerLogin join (select pur.MCOD, pur.CPUCOD, pur.RCOD, pur.GCOD, pur.HCOD, pur.PCOD, pur.CSCOD, sa.SAVECOD from SAVES as sa join PURCHASES as pur where sa.PURCOD = pur.COD) as save where save.SAVECOD = CustomerLogin.USERSAVE and USERNAME = '"+ userid +"' ");
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
                        while(res.next())
                        {
                            for(int i = 1; i <= 7; i++)
                            {
                                componentsCods.add(String.valueOf(res.getInt(i)));
                            }
                            sb.append("<tr>");
                            sb.append("<td>"+new ComponentParser().getComponent("MOTHERBOARD", String.valueOf(res.getInt(1))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("CPU", String.valueOf(res.getInt(2))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("RAM", String.valueOf(res.getInt(3))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("GRAPHICS_CARD", String.valueOf(res.getInt(4))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("HDRIVE", String.valueOf(res.getInt(5))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("POWER_SUPPLY", String.valueOf(res.getInt(6))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getComponent("PCCASE", String.valueOf(res.getInt(7))).replace("-CC-", " ")+"</td>");
                            sb.append("<td>"+new ComponentParser().getPrice(componentsCods)+"</td>");
                            sb.append("</tr>");
                            componentsCods.clear();
                        }
                        sb.append("</tbody>");
                        sb.append("</table>");
                        
                        this.closeall();

                    
        output = sb.toString();
        return output;
    }
    
    public static void main(String[] args) {
        
        try{
            UserConfigCreator ucf = new UserConfigCreator();
                System.out.println(ucf.createTable("ILKROCCIA"));
        }
        catch(SQLException sql)
        {
            System.out.println(sql.getMessage());
        }

    }
    
    
}
