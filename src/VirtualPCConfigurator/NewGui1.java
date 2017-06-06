/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;

import Components.CPULoader;
import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import java.sql.*;
/**
 *
 * @author Utente
 */
public class NewGui1 {

    private String user;
    private String pass;
        
    Connection conn;
    Statement mystmt;
    ResultSet res;
    
    public NewGui1(){
        
        conn = null;
        mystmt = null;
        res = null;     
         
    }
    
    public void Connect() throws SQLException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11176424?autoReconnect=true&useSSL=false", user, pass);
            mystmt = conn.createStatement();
            
            }
        catch(Exception ex)
        {
            System.err.println("Errore. Database non trovato");
        }
        
            
    }
     public Boolean setUP(String user, String pass)
    {
        if(!user.equals("") && !pass.equals(""))
        {
            this.user = user;
            
            this.pass = pass;
            
            return true;
        }
        else
            return false;
    }
    
    //close all connection from MySQL database
    public void closeall() throws SQLException
    {
        
            if(conn!=null)
            {
            conn.close();
            }
            if(mystmt !=null)
            {
            mystmt.close();
            }
            if(res!=null)
            {
            res.close();
            }
            System.out.println("MySQL connection closed");
        
    }
    //CPU:
    public void loadCPU(CPULoader cpu)
    {
        
        try
        {
            res = mystmt.executeQuery("select * from CPU");
            while(res.next())
            {
                cpu.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4), res.getInt(5), res.getInt(6), res.getInt(7), res.getDouble(8));
                
       
            
        }
        }
        
        catch(SQLException ex)
        {
            
        }
    }
    public void viewCPU() throws SQLException
    {
        res = mystmt.executeQuery("select * from CPU");
        while(res.next())
        {
            System.out.println(res.getString(1)+" "+ res.getString(2)+ " "+res.getString(3)+" "+ res.getDouble(4)+" "+res.getInt(5)+ " " +res.getInt(6)+ " "+ res.getInt(7)+ " "+ res.getDouble(8));
        }
    }
        
    
    //MotherBoard:
    public void loadMB(MBLoader mb)
    {
        try
        {
            res = mystmt.executeQuery("select * from motherboard");
            while(res.next())
            {
                
            }    
        }
        catch(SQLException ex)
        {
            
        }    
    }
       public void viewMB() throws SQLException
    {
        res = mystmt.executeQuery("select * from motherboard");
        while(res.next())
        {
            System.out.println(res.getString(1)+" "+ res.getString(2)+ " "+ res.getString(3)+" "+ res.getString(4)+ " "+ res.getString(5)+" "+ res.getInt(6)+" "+ res.getString(7)+" "+ res.getInt(8)+" "+res.getInt(9)+" "+ res.getDouble(10));
        }
    }
    
    //HDD:
    public void loadHDD(HDriveLoader hdd)
    {
        try
        {
            res = mystmt.executeQuery("select * from hdd");
            while(res.next())
            {
                
            }
        }
        catch(SQLException ex)
        {
            
        }
    }
      public void viewHDD() throws SQLException
    {
        res = mystmt.executeQuery("select * from hdd");
        while(res.next())
        {
            System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getDouble(4)+" "+res.getString(5)+" "+res.getInt(6)+" "+res.getInt(7)+" "+res.getDouble(8));
        }
    }
    public void loadGC(GCardLoader gc)
    {
        try
        {
            res = mystmt.executeQuery("select * from Graphics_Card");
            while(res.next())
            {
               
            }
        }
        catch(SQLException ex)
        {
            
        }
    }
        public void viewGC() throws SQLException{
        res = mystmt.executeQuery("select * from Graphics_Card");
        while(res.next())
        {
            System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getInt(5)+" "+res.getInt(6)+res.getDouble(7));
        }
          }
       
         
    public static void main(String []args){
     
    NewGui1 test = new NewGui1();
    
        
    try{
        test.setUP("sql11176424", "fDFSkH9nVq");
        test.Connect();
       
        
        test.viewCPU();
        System.out.println("\n");
        test.viewGC();
       
        System.out.println("\n");
        test.viewMB();
       
        System.out.println("\n");
        test.viewHDD();
        
        test.closeall();
        
        }
    catch(SQLException e)
        {
            
        }
 }
}
 


