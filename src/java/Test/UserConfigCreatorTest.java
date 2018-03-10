package Test;

import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import JSPElements.UserConfigCreator;
import java.sql.SQLException;

/**
 *
 * @author James Abbate
 */
public class UserConfigCreatorTest {
    public static void main(String[] args) {
        
        try{
                        DatabaseInit.getInstance().setConn("localhost", "Components", "virtualAdmin", "virtualPWD20!8");

            UserConfigCreator ucf = new UserConfigCreator();
                System.out.println(ucf.createTable("usr000"));
        }
        catch(ComponentLoadingException ecl)
        {
            
        }
        catch(SQLException sql)
        {
            System.out.println(sql.getMessage());
        }
    }
}
