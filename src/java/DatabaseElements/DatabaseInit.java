/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseElements;

/**
 * @author user
 */
public class DatabaseInit {
    private static  DatabaseInit instance;
    private static String host;
    private static String database;
    private static String username;
    private static String password;
    
    /**
     * Initialize the database
     */
    protected DatabaseInit()
    {
        host = "";
        database = "";
        username = "";
        password = "";
    }
    
    /**
     * create a new DatabaseInit if an instance is null
     * <p> otherwise return the already instantiated object
     * @return the instance of the data container
     */
    public static DatabaseInit getInstance()
    {
        if(instance == null){
            instance = new DatabaseInit();
        }
        return instance;
    }
    
    /**
     * Initialize the data to use the connection with DB
     * @param host the name of host 
     * @param database name of database
     * @param username id of user to connect with database
     * @param password password of user to connect with the database
     */
    public void setConn(String host, String database, String username, String password)
    {
        if(!host.equals("") && !database.equals("") && !username.equals("") && !password.equals(""))
        {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        }
    }

    /**
     * Get the name of host 
     * @return the name of host
     */
    public static String getHost() {
        return host;
    }

    /**
     * Get the name of database
     * @return name of the database
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * Get username for a database connection
     * @return username 
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Get password for a database connection
     * @return Password 
     */
    public static String getPassword() {
        return password;
    }
    
}
