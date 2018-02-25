package DatabaseElements;
import java.sql.*;

/**
 * This class DBConnection, creates a connection with the database.
 * <p>
 * This class work with the database.
 * 
 * @author Utente
 */
public class DBConnection 
{
    
    protected Connection conn;
    protected Statement mystmt;
    protected ResultSet res;
    private static DatabaseInit data;
    
    /**
     * Sets the variables conn, mystmt, res to null for the connection.
     * Initializes the data variable with the single instance that it must contain
     * <p>
     * This method is the constructor method.
     */
    public DBConnection()
    {
        conn = null;
        mystmt = null;
        res = null;
        data = DatabaseInit.getInstance();
    } 
    
     /**
     * Use the param conn and mystmt to get a connection and to create a statement
     * @return the statment of the connection
     * @throws SQLException if an SQL exception occurred
     */
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

    /**
     * Close connection from MySQL database.
     * @throws SQLException if occured an SQL exception
     */
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
