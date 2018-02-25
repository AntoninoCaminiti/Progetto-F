package Test;
import Components.RAMLoader;
import DatabaseElements.DBComponentController;
import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import java.sql.*;

/**
 *
 * @author James Abbate
 */
public class DBConnectionNoErrorsTest {
    public static void main(String[] args) {
        
        DBComponentController db;
        RAMLoader testRam1;
        
        try{
            DatabaseInit.getInstance().setConn("", "", "", "");
            //Apertura della connessione
            db = new DBComponentController();
            //TEST LOADRAM
            
            testRam1 = db.loadRAM();
            testRam1.printAll();
            
            //TEST FILLDBCPU
            //db.filldbCPU("INTEL", "i5-300k", "LGA1151", 2.0 , 3, 50, 60.0);
            //TEST REMOVESHRT (con codice inesistente ed esistente)
            //db.removeShrt("cpu", "2026"); //Se quella che non funziona va prima non continua ad usare removeshrt per un altro.
            //db.removeShrt("cpu", "2007");
            //Chiusura della connessione
            db.closeall();
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
