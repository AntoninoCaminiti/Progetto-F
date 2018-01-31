package JSPElements;
import DatabaseElements.DBConnection;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class ComponentParser extends DBConnection {
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet res = null;
    
    public ComponentParser() throws SQLException
    {
        stmt = this.Connect();
    }
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
        
        return pricef.format(price);
    }
    
    public static void main(String[] args) {
        try{
        ComponentParser c = new ComponentParser();
            System.out.println(c.getComponent("HDRIVE", "5002"));
        ArrayList<String> a = new ArrayList<>();
        a.add("1003");
        a.add("2011");
        a.add("3004");
        a.add("4004");
        a.add("5002");
        a.add("6004");
        a.add("7007");
            System.out.println(c.getPrice(a));
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
}