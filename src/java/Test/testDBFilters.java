package Test;
import DatabaseElements.DBFilters;
import Components.*;
import java.sql.*;
/**
 *
 * @author James Abbate
 */
public class testDBFilters {
    public static void main(String[] args) {
        DBFilters filterTest1 = null;
        try{
            //Connessione
            filterTest1 = new DBFilters();
            filterTest1.Connect();
            
            CPULoader testCpu;
            RAMLoader testRam;
            MBLoader testMb;
            //TEST ISSELECTED
            testMb = filterTest1.iSelected();
            //Stampa la lista dei brand della motherboard
            System.out.println("+++"+testMb.listBrands());
            
            //TEST ISSELECTED2
            //Filtraggio CPU data brand e model di componente MB "ESISTENTE"
            testCpu = filterTest1.iSelected2("ASRock", "970 EXTREME4");
            System.out.println(testCpu.listBrands());
            //Filtraggio CPU data brand e model di componente MB "NON ESISTENTE"
            testCpu = filterTest1.iSelected2("Asus", "Z170-A");
            System.out.println(testCpu.listBrands());
            
            //TEST CPUFILTERED
            //Filtraggio CPU data codice di componente MB "ESISTENTE"
            testCpu = filterTest1.cpuFiltered("1004");
            System.out.println(testCpu.listBrands());
            //Filtraggio CPU data codice di componente MB "NON ESISTENTE"
            testCpu = filterTest1.cpuFiltered("1604");
            System.out.println(testCpu.listBrands());
            
            //TEST ISSELECTED3
            //Filtraggio RAM data brand e model di componente MB "ESISTENTE"
            testRam = filterTest1.isSelected3("ASRock", "970 EXTREME4");
            System.out.println(testRam.listBrands());
            //Filtraggio RAM data brand e model di componente MB "NON ESISTENTE"
            testRam = filterTest1.isSelected3("Asus", "Z170-A");
            System.out.println(testRam.listBrands());
        }
        catch(SQLException sr)
        {}
    }
}
