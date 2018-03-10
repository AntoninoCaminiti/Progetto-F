package DatabaseElements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUserHandler {
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet res = null;
    
    /**
     * Sets the variables conn, mystmt, res to null for the connection.
     * Initializes the data variable with the single instance that it must contain
     * <p>
     * This method is the constructor method.
     * @throws SQLException if an SQL exception is occurred
     */
    public DBUserHandler() throws SQLException
    {
        DBConnection connection = new DBConnection();
        conn = connection.Connect();
        stmt = conn.createStatement();
    }
    
    /**
     * Insert new user with all data (id, pass, email, addr) in database
     * <p> checking that it does not already exist
     * @param uname the ID that customer use to connect
     * @param pwd the pasword that customer use to connect 
     * @param email the email that customer use to connect
     * @param addr the addres that customer use to connect
     * @return boolean true if user is created else return false 
     * @throws SQLException if an SQL exception is occurred
     */
    public Boolean addUser(String uname, String pwd, String email, String addr) throws SQLException
    {
        Boolean st = false;
        if(checkUser(uname) == false)
        {
            stmt.executeUpdate("insert into CustomerLogin (USERNAME, PASS, EMAIL, ADDRESS) values ('" + uname + "','" + pwd + "','" + email + "','" + addr +"')");
            System.out.println("Utente " + uname + " creato");
            conn.close();
            stmt.close();
            st = true;
        }
        else
        {
            System.err.println("Utente " + uname + " già esistente");
        }
        
        return st;
    }
    
    /**
     * Insert new user with all data (id, pass) in database
     * <p> checking that it does not already exist
     * @param uAdmin the ID that admin use to connect
     * @param pAdmin the pasword that admin use to connect 
     * @return boolean true if user is created else return false 
     * @throws SQLException if an SQL Exception is occurred
     */
    public Boolean addAdmin(String uAdmin, String pAdmin) throws SQLException
    {
        Boolean st = false;
        if(checkAdmin(uAdmin) == false)
        {
            stmt.executeUpdate("insert into ADMINLOGIN (USERNAME, PASS) values ('" + uAdmin + "','" + pAdmin + "')");
            System.out.println("Amministratore " + uAdmin + " creato");
            conn.close();
            stmt.close();
            st = true;
        }
        else
        {
            System.err.println("Amministratore " + uAdmin + " già esistente");
        }
        
        return st;
    }
    
    /**
     * Check if user already exist
     * @param name username to check if already exist
     * @return boolean false  if ID of customer doesn't exist else return true
     * @throws SQLException if an SQL exception is occurred
     */
    public Boolean checkUser(String name) throws SQLException
    {
        Boolean st = false;
        res = stmt.executeQuery("select USERNAME from CustomerLogin");
        while(res.next())
        {
            if(name.equals(res.getString(1)))
            {
                st = true;
            }
        }
        conn.close();
        stmt.close();
        res.close();
        return st;
    }
    
    /**
     * Check if user already exist
     * @param name admin username to check if already exist
     * @return boolean false if ID of admin doesn't exist otherwise return true
     * @throws SQLException if an SQL exception is occurred
     */
    public Boolean checkAdmin(String name) throws SQLException
    {
        Boolean st = false;
        res = stmt.executeQuery("select USERNAME from ADMINLOGIN");
        while(res.next())
        {
            if(name.equals(res.getString(1)))
            {
                st = true;
            }
        }
        return st;
    }
    
    /**
     * get the status of the constraint for the CPU
     * @return Boolean true if the constraint is on, otherwise return false
     * @throws SQLException if an SQL Exception is occurred
     */
    public Boolean getCPUStatusConstr() throws SQLException
    {
        Boolean status = true;
        res = stmt.executeQuery("select CPUFLAG from ADMINCONTROLS");
        while(res.next())
        {
            if(res.getInt(1)==1) status = true;
            if(res.getInt(1)==0) status = false;   
        }
        conn.close();
        stmt.close();
        res.close();
        return status;
    }
    
    /**
     * Set the constraint status of component CPU
     * @param status of component's constraint CPU
     * @throws SQLException if an SQL Exception is occurred 
     */
    public void setCPUStatusConstr(Boolean status) throws SQLException
    {
            if(status == false)
            {
                stmt.executeUpdate("update ADMINCONTROLS set CPUFLAG = 0");
            }
            if(status == true)
            {
                stmt.executeUpdate("update ADMINCONTROLS set CPUFLAG = 1");
            }
        conn.close();
        stmt.close();
        res.close();
    }
    
    /**
     * get the status of the constraint for the CPU
     * @return Boolean true if the constraint is on, otherwise return false
     * @throws SQLException if an SQL Exception is occurred
     */
    public Boolean getRAMStatusConstr() throws SQLException
    {
        Boolean status = true;
        res = stmt.executeQuery("select RAMFLAG from ADMINCONTROLS");
        while(res.next())
        {
            if(res.getInt(1)==1) status = true;
            if(res.getInt(1)==0) status = false;   
        }
        conn.close();
        stmt.close();
        res.close();
        return status;
    }    
    
    /**
     * Set the constraint status of component CPU
     * @param status of component's constraint CPU
     * @throws SQLException if an SQL Exception is occurred 
     */
    public void setRAMStatusConstr(Boolean status) throws SQLException
    {
            if(status == false)
            {
                stmt.executeUpdate("update ADMINCONTROLS set RAMFLAG = 0");
            }
            if(status == true)
            {
                stmt.executeUpdate("update ADMINCONTROLS set RAMFLAG = 1");
            }
            conn.close();
            stmt.close();
            res.close();
    }
}
