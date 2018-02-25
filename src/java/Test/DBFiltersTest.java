package Test;
import DatabaseElements.DBFilters;
import Components.*;
import DatabaseElements.DBComponentController;
import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import Exceptions.NoCPUMatchedException;
import Exceptions.NoRAMMatchedException;
import java.sql.*;
/**
 *
 * @author James Abbate
 */
public class DBFiltersTest {
    public static void main(String[] args) {
        DBFilters filterTest1 = null;
        try{
            //Connessione
            
            
            DatabaseInit.getInstance().setConn("", "", "", "");
            filterTest1 = new DBFilters();
            
            //filterTest1.Connect();
            
            CPULoader testCpu;
            RAMLoader testRam;
            MBLoader testMb = new DBComponentController().loadMB();
            
            
            //Stampa la lista dei brand e  della motherboard
            //testMb.printAll();
            
            
            //TEST filterCPU
            //Filtraggio CPU data brand e model di componente MB "ESISTENTE"
            //testCpu = filterTest1.filterCPU("ASRock", "970 EXTREME4");
            //System.out.println(testCpu.listBrands());
            //Filtraggio CPU data brand e model di componente MB "NON ESISTENTE"
            //testCpu = filterTest1.filterCPU("Asus", "Z170-A");
            //testCpu.printAll();
            
            //TEST filterCPU
            //Filtraggio CPU data codice di componente MB "ESISTENTE"
            testCpu = filterTest1.filterCPU("1016");
            testCpu.printAll();
            //Filtraggio CPU data codice di componente MB "NON ESISTENTE"
            testCpu = filterTest1.filterCPU("1604");
            System.out.println(testCpu.listBrands());
            
            //TEST filterRAM
            //Filtraggio RAM data brand e model di componente MB "ESISTENTE"
            testRam = filterTest1.filterRAM("ASRock", "970 EXTREME4");
            System.out.println(testRam.listBrands());
            //Filtraggio RAM data brand e model di componente MB "NON ESISTENTE"
            testRam = filterTest1.filterRAM("Asus", "Z170-A");
            System.out.println(testRam.listBrands());
        }
        catch(ComponentLoadingException ex)
        {
            System.err.println(ex.getMessage());
        }
        catch(NoCPUMatchedException ncm)
        {
            System.err.println(ncm.getMessage());
        }
        catch(NoRAMMatchedException nrm)
        {
            System.err.println(nrm.getMessage());
        }
        catch(SQLException sr)
        {
            System.err.println(sr.getMessage());
        }
    }
}
