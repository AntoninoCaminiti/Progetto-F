package Test;
import DatabaseElements.DBConnection;
import Components.CPULoader;
import Components.CaseLoader;
import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.PSLoader;
import Components.RAMLoader;
import java.sql.*;

/**
 *
 * @author James Abbate
 */
public class testDBConnection {
    public static void main(String[] args) {
        
        DBConnection db = new DBConnection();
        RAMLoader testRam1 = new RAMLoader();
        
        try{
            //Apertura della connessione
            db.Connect();
            //TEST LOADRAM
            db.loadRAM(testRam1);
            testRam1.printAll();
            //TEST FILLDBCPU
            //db.filldbCPU("INTEL", "i5-300k", "LGA1151", 2.0 , 3, 50, 60.0);
            //TEST REMOVESHRT (con codice inesistente ed esistente)
            db.removeShrt("cpu", "2026"); //Se quella che non funziona va prima non continua ad usare removeshrt per un altro.
            db.removeShrt("cpu", "2007");
            //Chiusura della connessione
            db.closeall();
        }
        catch(SQLException e)
        {}
    }
}
