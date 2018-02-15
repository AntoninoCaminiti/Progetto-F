package Test;

import JSPElements.UserConfigCreator;
import java.sql.SQLException;

/**
 *
 * @author James Abbate
 */
public class testUserConfigCreator {
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
