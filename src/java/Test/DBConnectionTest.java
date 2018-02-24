/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DatabaseElements.DBConnection;
import DatabaseElements.DatabaseInit;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class DBConnectionTest {
    
    
        public static void main(String[] args) {
        DBConnection db = new DBConnection();
        
        try{
        DatabaseInit.getInstance().setConn("", "", "", "");
        db.Connect();
        db.closeall();
        
        }

        catch(SQLException e)
        {
            if(e.getErrorCode() == 0)
            {
                System.err.println("Host inesistente o errato");
            }
            if(e.getErrorCode() == 1045)
            {
                System.err.println("Username o password invalidi");
            }
            if(e.getErrorCode() == 1049)
            {
                System.err.println("Nome database errato");
            }
        }
    }
    
}
