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
    
    private static String host = "";
    private static String database = "";
    private static String username = "";
    private static String password = "";
    
    
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
    
    
    
    

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public static void main(String[] args) {
        DatabaseInit id = new DatabaseInit();
        
        System.out.println(id.getHost());
    }
    
    
}
