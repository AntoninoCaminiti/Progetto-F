/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseElements;

/**
 *
 * @author user
 */
public class DatabaseInit {
    private static  DatabaseInit instance;
    private static String host;
    private static String database;
    private static String username;
    private static String password;
    
    protected DatabaseInit()
    {
        host = "";
        database = "";
        username = "";
        password = "";
    }
    
    public static DatabaseInit getInstance()
    {
        if(instance == null){
            instance = new DatabaseInit();
        }
        return instance;
    }
    
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

    public static String getHost() {
        return host;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
    
}
