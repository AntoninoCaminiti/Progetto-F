/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD;

import OLD.CPUs;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class JDBCTest {
    String user = "AdminKing";
    String pass = "SuperAMG2017#";
    ArrayList<String> brand = new ArrayList<>();
    ArrayList<String> model = new ArrayList<>();
    ArrayList<String> socket = new ArrayList<>();
    ArrayList<String> chipset = new ArrayList<>();
    ArrayList<Double> freq = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<Integer> cores = new ArrayList<>();
    ArrayList<Integer> tdp = new ArrayList<>();
    CPUs c1;
    
    
    public void initCPU()
    {
        c1 = new CPUs(brand, model, socket, chipset, freq, quantity, cores, tdp);
        System.out.println("OK");
    }
    
    public Double clockk(String nm)
    {
        return c1.getClock(nm);
    }
    
    
    public String getUser()
    {
        return user;
    }
    
    public String getPass()
    {
        return pass;
    }
    
    public void connect() throws SQLException
    {
        String table = "cpu";
        Connection conn = null;
        Statement mystmt = null;
        ResultSet res = null;
    
    
    
       
    
    
    
        
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Components?autoReconnect=true&useSSL=false", user, pass);
            mystmt = conn.createStatement();
            res = mystmt.executeQuery("select * from "+table);
            
            
            
            while(res.next())
            {
                int k = 0;
                brand.add(res.getString("brand"));
                model.add(res.getString("model"));
                socket.add(res.getString("socket"));
                chipset.add(res.getString("chipset"));
                freq.add(res.getDouble("frequency"));
                quantity.add(res.getInt("quantity"));
                cores.add(res.getInt("cores"));
                tdp.add(res.getInt("tdp"));
                
                //System.out.println(brand.get(k)+" "+model.get(k)+" "+socket.get(k)+" "+chipset.get(k)+" "+freq.get(k)+" "+quantity.get(k)+ " "+cores.get(k)+" "+tdp.get(k));
                k++;
            }
            
            
        }
        catch(Exception ex)
        {
            System.err.println("Errore. Database non trovato");
        }
        finally{
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
            
        }
        
        
        
    
        
        
    }
    
    

public static void main(String[] args)
{
    JDBCTest t1 = new JDBCTest();
    
    try
    {
    t1.connect();
    t1.initCPU();
        System.out.println(t1.clockk("AMD"));
    }
    catch(SQLException ex)
    {
        
    }
    
    
}
    
  
    
    
}
