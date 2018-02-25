package Test;

import DatabaseElements.DatabaseInit;
import JSPElements.HTMLTableCreator;

/**
 *
 * @author James Abbate
 */
public class HTMLTableCreatorTest {
    public static void main(String[] args) {
        //set conn first
        DatabaseInit.getInstance().setConn("", "", "", "");
        HTMLTableCreator hd = new HTMLTableCreator();
        //System.out.println(hd.createMotherboard(true));
        System.out.println(hd.createCPU(false, true, "MSI", "B150M BAZOOKA"));
    }
}
