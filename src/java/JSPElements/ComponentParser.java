package JSPElements;
import DatabaseElements.DBConnection;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class ComponentParser extends DBConnection {
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet res = null;
    
    /**
     * Create a statment to connect with database
     * @throws SQLException if an SQL Exception is occurred
     */
    public ComponentParser() throws SQLException
    {
        stmt = this.Connect();
    }
    
    /**
     * Get a string of the brand and model of a component (using the string -CC- in order to split them) given its code 
     * @param table the name's table that containing the component
     * @param cod the code of the corresponding component
     * @return the brand and the model of corresponding component
     * @throws SQLException if an SQL exception is occurred
     */
    public String getComponent(String table, String cod) throws SQLException
    {
        String output = " ";
        
        res = stmt.executeQuery("select * from " + table + " where cod = " + cod.trim());
            while(res.next())
            {
                output = res.getString(2) + "-CC-" + res.getString(3);
            }
           
        this.closeall();   
        return output;
    }                                                                                                                                                                                   
    
    /**
     * Get the total price of a saved configuration given the set of codes in input
     * @param data list of component's code (one code for every component) to calculate the total price
     * @return total price of configuration
     * @throws SQLException if an SQL exception is occurred 
     */
    public String getPrice(ArrayList data) throws SQLException
    {
        Double price = 0.0;
        ArrayList<String> tables = new ArrayList<>();
        
        tables.add("MOTHERBOARD");
        tables.add("CPU");
        tables.add("RAM");
        tables.add("GRAPHICS_CARD");
        tables.add("HDRIVE");
        tables.add("POWER_SUPPLY");
        tables.add("PCCASE");
        
        for(int i = 0; i < tables.size(); i++)
        {            
            //System.out.println(tables.get(i) + " " + data.get(i));
            res = stmt.executeQuery("select PRICE from " + tables.get(i)  + " where COD = "+ data.get(i));
            while(res.next())
            {
                price += res.getDouble("PRICE");
            }
        }
        DecimalFormat pricef = new DecimalFormat("#0.00 €");
        this.closeall();
        return pricef.format(price);
    }
}