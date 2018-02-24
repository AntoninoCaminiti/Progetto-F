package Test;

import DatabaseElements.DBUserHandler;
import java.sql.SQLException;

/**
 *
 * @author James Abbate
 */
public class testDBUserHandler {
    public static void main(String[] args)
    {
        DBUserHandler testDb;
        try{
            //Create DBUserHandler object
            testDb = new DBUserHandler();
            
            //AddUser Method application
            //Add a new user
            testDb.addUser("user4", "yoo", "edfcdfv@csdc.it", "eeeeeeeee");
            //Try to add the same user another time
            testDb.addUser("user4", "yoo", "edfcdfv@csdc.it", "eeeeeeeee");
            //Add a new user
            testDb.addUser("user5", "yoo", "edfcdfv@csdc.it", "eeeeeeeee");
            
            //Check CPU FLAG STATUS, used to set compatibility constrain
            System.out.println(testDb.getCPUStatusConstr());
            //Change CPU FLAG STATUS
            testDb.setCPUStatusConstr(false);
            //Check CPU FLAG STATUS, used to set compatibility constrain
            System.out.println(testDb.getCPUStatusConstr());
            //Change CPU FLAG STATUS
            testDb.setCPUStatusConstr(true);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
