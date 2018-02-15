package Test;

import JSPElements.HTMLTableCreator;

/**
 *
 * @author James Abbate
 */
public class testHTMLTableCreator {
    public static void main(String[] args) {
        HTMLTableCreator hd = new HTMLTableCreator();
        System.out.println(hd.createMotherboard(true));
        System.out.println(hd.createMotherboard(false));
    }
}
