package Test;
import Components.RAM;
import DatabaseElements.DBComponentController;
import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author James Abbate
 */
public class DBConnectionNoErrorsTest {
    public static void main(String[] args) {
        
        DBComponentController db;
        ArrayList <RAM> testRam1;
        
        try{
            DatabaseInit.getInstance().setConn("localhost", "Components", "virtualAdmin", "virtualPWD20!8");
            //Apertura della connessione
            db = new DBComponentController();
            //TEST LOADRAM
            
            testRam1 = db.loadRAM();
            testRam1.toString();
            
            //TEST FILLDBCPU
            //db.filldbCPU("INTEL", "i5-300k", "LGA1151", 2.0 , 3, 50, 60.0);
            //TEST REMOVESHRT (con codice inesistente ed esistente)
            //db.removeShrt("cpu", "2026"); //Se quella che non funziona va prima non continua ad usare removeshrt per un altro.
            //db.removeShrt("cpu", "2007");
            //Chiusura della connessione
        }
        catch(ComponentLoadingException e)
        {
            System.err.println(e.getMessage());
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
