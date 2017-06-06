/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;



import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.CPULoader;
import Components.RAMLoader;
import Components.PSLoader;
import java.sql.*;




/**
 *
 * @author user
 */
public class DBConnection 
{     
    private String user;
    private String pass;
        
    Connection conn;
    Statement mystmt;
    ResultSet res;
    
    
    
    public DBConnection()
    {
        conn = null;
        mystmt = null;
        res = null;
    }
    
    
    
    public void Connect() throws SQLException
    {
        
        
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
    
    
    //optional
    public void viewDB() throws SQLException
    {
        res = mystmt.executeQuery("select * from cpu, motherboard");
        while(res.next())
        {
            System.out.println(res.getString("brand") + " " + res.getString("model") + " " + res.getString("socket") + " " + res.getDouble("frequency") + " " + res.getInt("cores") + " " + res.getInt("tdp") + " " + res.getInt("qt") + " " + res.getDouble("price") + " | " + res.getString(9) + " " + res.getString(10) + " " + res.getString("chipset") + " " + res.getString(12) + " " + res.getString("formfactor") + " " + res.getInt("ramslots") + " " + res.getInt("maxram") + " " + res.getInt(16) + " " +res.getDouble(17));
        }
    }
    
    //edit the database, inserting data
    public void insOpt(String cmd) throws SQLException
    {
        int ress; 
        ress = mystmt.executeUpdate(cmd);
        System.out.println(ress+" rows affected");
        
    }
    
    
    //pass the username and password from LoginForm
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
    
    public void loadCPU(CPULoader cpu)
    {
        try
        {
            res = mystmt.executeQuery("select * from cpu");
            while(res.next())
            {
                cpu.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4), res.getInt(5), res.getInt(6), res.getInt(7), res.getDouble(8));
                /*
                cpu.addBrand(res.getString(1));
                cpu.addModel(res.getString(2));
                cpu.addSocket(res.getString(3));
                cpu.addFrequency(res.getDouble(4));
                cpu.addCore(res.getInt(5));
                cpu.addTDP(res.getInt(6));
                cpu.addQuantity(res.getInt(7));
                cpu.addPrice(res.getDouble(8));
                */
            }
            
            
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    
    public void filldbCPU(String brand, String model, String socket, Double frequency, int core, int tdp, int qt, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert values into cpu('"+model+"', '"+brand+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+qt+", "+price+")");
            ress = mystmt.executeUpdate("insert into cpu values('"+brand+"', '"+model+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+qt+", "+price+")");
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    
    public void removeFromCPU(String brand, String model, String socket, Double frequency, int core, int tdp, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert values into cpu('"+model+"', '"+brand+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+qt+", "+price+")");
            
            ress = mystmt.executeUpdate("delete from cpu where brand = '"+brand+"' and model = '"+model+"' and socket = '"+socket+"' and frequency = "+frequency+" and cores = "+core+" and tdp = "+tdp+" and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    
    public void loadMB(MBLoader mb)
    {
        try
        {
            res = mystmt.executeQuery("select * from motherboard");
            while(res.next())
            {
                mb.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getDouble(9));
                
            }
            
            
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    public void filldbMB(String brand, String model, String chipset, String socket, String formfactor ,int ramslot, int maxram, int tdp, Double price)
    {
        try
        {
            int ress;            
            ress = mystmt.executeUpdate("insert into motherboard values('"+brand+"', '"+model+"', '"+chipset+"', '"+socket+"', '"+formfactor+"', "+ramslot+", "+maxram+", "+tdp+", "+price+")");
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    public void removeFromMotherBoard(String brand, String model, String chipset, String socket, String formfactor ,int ramslot, int maxram, int tdp, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert values into cpu('"+model+"', '"+brand+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+qt+", "+price+")");
            
            ress = mystmt.executeUpdate("delete from motherboard where brand = '"+brand+"' and model = '"+model+"' and chipset = '"+chipset+"' and socket = '"+socket+"' and formfactor = '"+formfactor+"' and ramslots = "+ramslot+" and maxram = "+maxram+" and tdp = "+tdp+" and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    public void filldbPS(String brand, String model, String serie, String form, String efficiency ,int maxtdp, String modular, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert into motherboard values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+efficiency+"', "+maxtdp+", "+modular+", "+price+")");
            ress = mystmt.executeUpdate("insert into PS values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+efficiency+"', "+maxtdp+", '"+modular+"', "+price+")");
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
    }
    
        
    public void loadPS(PSLoader ps)
    {
        try
        {
            res = mystmt.executeQuery("select * from PS");
            while(res.next())
            {
                ps.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getDouble(8));
            }
            
            
        }
        catch(SQLException ex)
        {
            
        }
        
    }
        
    
    
    
    public void removeFromPowerSupply(String brand, String model, String serie, String form, String efficiency ,int maxtdp, String modular, Double price)
    {
        try
        {
            int ress;            
            ress = mystmt.executeUpdate("delete from PS where brand = '"+brand+"' and model = '"+model+"' and series = '"+serie+"' and form = '"+form+"' and efficiency = '"+efficiency+"' and maxtdp = "+maxtdp+" and modular = '"+modular+"' and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    public void loadRAM(RAMLoader ram)
    {
        try
        {
            res = mystmt.executeQuery("select * from RAM");
            while(res.next())
            {
                ram.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getDouble(9));
            }
            
            
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    
    public void filldbRAM(String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert into motherboard values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+efficiency+"', "+maxtdp+", "+modular+", "+price+")");
            ress = mystmt.executeUpdate("insert into RAM values('"+brand+"', '"+model+"', '"+type+"', '"+speed+"', "+tdp+", "+nom+", "+som+ ","+ size +", "+price+")");
            
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    
    public void removeFromRAM(String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price)
    {
        try
        {
            int ress;            
            ress = mystmt.executeUpdate("delete from RAM where brand = '"+brand+"' and model = '"+model+"' and type = '"+type+"' and speed = '"+speed+"' and tdp = "+tdp+" and nom = "+nom+" and som = "+som+ " and size = "+ size +" and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    public void loadGCard(GCardLoader gc)
    {
        try
        {
            res = mystmt.executeQuery("select * from gcard");
            while(res.next())
            {
                gc.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getInt(6), res.getDouble(7), res.getDouble(8));
            }
            
            
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    public void filldbGCard(String brand, String model, String serie, String chipset, int mem, int tdp, Double clock, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert into motherboard values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+efficiency+"', "+maxtdp+", "+modular+", "+price+")");
            ress = mystmt.executeUpdate("insert into gcard values('"+brand+"', '"+model+"', '"+serie+"', '"+chipset+"', "+mem+", "+tdp+","+ clock +", "+price+")");
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
    }
    
    public void removeFromGCard(String brand, String model, String serie, String chipset, int mem, int tdp, Double clock, Double price)
    {
        try
        {
            int ress;            
            ress = mystmt.executeUpdate("delete from gcard where brand = '"+brand+"' and model =  '"+model+"' and series = '"+serie+"' and chipset = '"+chipset+"' and memory = "+mem+" and tdp = "+tdp+" and clock = "+ clock +" and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
    public void loadHDrive(HDriveLoader hdd)
    {
        try
        {
            res = mystmt.executeQuery("select * from hdrive");
            while(res.next())
            {
                hdd.fillLoader(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getDouble(9));
            }
        }
        catch(SQLException ex)
        {
            
        }
        
    }
    
    public void filldbHDrive(String brand, String model, String serie, String form, String type, int size, int tdp, int cache, Double price)
    {
        try
        {
            int ress;
            //System.out.println("insert into motherboard values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+efficiency+"', "+maxtdp+", "+modular+", "+price+")");
            ress = mystmt.executeUpdate("insert into hdrive values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+type+"', "+size+","+ tdp + ", " + cache +", "+price+")");
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
public void removeFromHDrive(String brand, String model, String serie, String form, String type, int size, int tdp, int cache, Double price)
    {
        try
        {
            int ress;            
            ress = mystmt.executeUpdate("delete from hdrive where brand = '"+brand+"' and model = '"+model+"' and series = '"+serie+"' and form = '"+form+"' and type = '"+type+"' and size = "+size+" and tdp = "+ tdp + " and cache = " + cache +" and price = "+price);
            System.out.println(ress + " query affected");
        }
        catch(SQLException ex)
        {
            
        }
            
        
    }
    
/*
    public static void main(String[]args)
    {
        DBConnection test = new DBConnection();
        
        try{
        test.setUP("AdminKing", "SuperAMG2017#");
        test.Connect();
        test.removeFromHDrive("str1", "str2", "str3", "str4", "str5", 1, 2, 3, 4.0);
        //test.removeFromMotherBoard("First string field", "Second string field", "Third string field", "Fourth string field", "Fifth string field", 4,5,2,2.0);
        
        //test.viewDB();
        //test.filldbHDrive("s1", "s2", "s3", "s4", "s5", 1, 2, 3, 90.0);
        
        test.closeall();
        }
        
        catch(SQLException e)
        {
            
        }
    }
    */
    
}
