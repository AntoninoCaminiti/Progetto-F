package DatabaseElements;
import Components.CPULoader;
import Components.CaseLoader;
import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.PSLoader;
import Components.RAMLoader;
import Exceptions.InsertComponentException;
import java.sql.*;

public class DBConnection 
{
    
    protected Connection conn;
    protected Statement mystmt;
    protected ResultSet res;
    private static DatabaseInit data;
    
    public DBConnection()
    {
        conn = null;
        mystmt = null;
        res = null;
        data = new DatabaseInit();
    } 
    
    
    
    public Statement Connect() throws SQLException
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+ data.getHost() + ":3306/"+ data.getDatabase(), data.getUsername(), data.getPassword());
            mystmt = conn.createStatement();
        }
        catch(ClassNotFoundException ex)
        {
            System.err.println("Errore. Driver MySQL non trovato");
        }
        
        return mystmt;
    }

    //close all connection from MySQL database
    public void closeall() throws SQLException
    {
            if(conn!=null)
            {
                conn.close();
            }
            if(mystmt!=null)
            {
                mystmt.close();
            }
            if(res!=null)
            {
                res.close();
            }
           
    }
}
