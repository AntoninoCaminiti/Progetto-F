package Test;

import Exceptions.ComponentLoadingException;
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
        System.out.println(c.getComponent(5002));
        }
        catch(ComponentLoadingException cle)
        {
            System.err.println(cle.getMessage());
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
}
