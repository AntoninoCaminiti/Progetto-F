package Test;

import JSPElements.ComponentParser;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author James Abbate
 */
public class ComponentParserTest {
    public static void main(String[] args) {
        try{
        //GetComponent Method - Print Brand and Model of a component
        ComponentParser c = new ComponentParser();
        System.out.println(c.getComponent("HDRIVE", "5002"));
        
        //Example of Configuration
        ArrayList<String> a = new ArrayList<>();
        a.add("1003");
        a.add("2011");
        a.add("3004");
        a.add("4004");
        a.add("5002");
        a.add("6004");
        a.add("7007");
        //Method Get Price
        System.out.println(c.getPrice(a));
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
}
