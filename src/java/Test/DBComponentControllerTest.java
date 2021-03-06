/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Components.CPU;
import DatabaseElements.DBComponentController;
import DatabaseElements.DatabaseInit;
import Exceptions.ComponentLoadingException;
import Exceptions.InsertComponentException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class DBComponentControllerTest {
    
        public static void main(String[] args) {
        
        
        try{
            DatabaseInit.getInstance().setConn("", "", "", "");
            DBComponentController dbc = new DBComponentController();
            
            ArrayList <CPU> cpu = dbc.loadCPU();
            cpu.toString();
            dbc.filldbCPU("AMD", "FX-8320", "AM3", 3.0, 5, 3, 179.0);
            cpu.toString();
        }
        catch(InsertComponentException dbe){
            System.err.println(dbe.getMessage());
        }
        catch(ComponentLoadingException cpe)
        {
            System.err.println(cpe.getMessage());
        }
        catch(SQLException sq)
        {
            System.err.println(sq.getMessage());
        }
    }
    
}
