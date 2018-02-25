package DatabaseElements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUserHandler extends DBConnection {
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet res = null;
    
    public DBUserHandler() throws SQLException
    {
        stmt = this.Connect();
    }
    
    public Boolean addUser(String uname, String pwd, String email, String addr) throws SQLException
    {
        Boolean st = false;
        if(checkUser(uname) == false)
        {
            stmt.executeUpdate("insert into CustomerLogin (USERNAME, PASS, EMAIL, ADDRESS) values ('" + uname + "','" + pwd + "','" + email + "','" + addr +"')");
            System.out.println("Utente " + uname + " creato");
            st = true;
        }
        else
        {
            System.err.println("Utente " + uname + " già esistente");
        }
        
        return st;
    }
    
    public Boolean addAdmin(String uAdmin, String pAdmin) throws SQLException
    {
        Boolean st = false;
        if(checkAdmin(uAdmin) == false)
        {
            stmt.executeUpdate("insert into ADMINLOGIN (USERNAME, PASS) values ('" + uAdmin + "','" + pAdmin + "')");
            System.out.println("Amministratore " + uAdmin + " creato");
            st = true;
        }
        else
        {
            System.err.println("Amministratore " + uAdmin + " già esistente");
        }
        
        return st;
    }
    
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
        
        return st;
    }
    
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
    
    public Boolean getCPUStatusConstr() throws SQLException
    {
        Boolean status = true;
        res = mystmt.executeQuery("select CPUFLAG from ADMINCONTROLS");
        while(res.next())
        {
            if(res.getInt(1)==1) status = true;
            if(res.getInt(1)==0) status = false;   
        }
        return status;
    }
    
    public void setCPUStatusConstr(Boolean status) throws SQLException
    {
            if(status == false)
            {
                mystmt.executeUpdate("update ADMINCONTROLS set CPUFLAG = 0");
            }
            if(status == true)
            {
                mystmt.executeUpdate("update ADMINCONTROLS set CPUFLAG = 1");
            }
    }
    
    public Boolean getRAMStatusConstr() throws SQLException
    {
        Boolean status = true;
        res = mystmt.executeQuery("select RAMFLAG from ADMINCONTROLS");
        while(res.next())
        {
            if(res.getInt(1)==1) status = true;
            if(res.getInt(1)==0) status = false;   
        }
        
        return status;
    }    
    
    public void setRAMStatusConstr(Boolean status) throws SQLException
    {
            if(status == false)
            {
                mystmt.executeUpdate("update ADMINCONTROLS set RAMFLAG = 0");
            }
            if(status == true)
            {
                mystmt.executeUpdate("update ADMINCONTROLS set RAMFLAG = 1");
            }
    }
}
