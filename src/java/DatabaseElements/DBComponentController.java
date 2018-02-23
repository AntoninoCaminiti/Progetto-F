/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseElements;

import Components.CPULoader;
import Components.CaseLoader;
import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.PSLoader;
import Components.RAMLoader;
import Exceptions.InsertComponentException;
import Exceptions.ComponentLoadingException;
import Exceptions.DeleteComponentException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class DBComponentController extends DBConnection{
    
    private Statement stmt = null;
    private ResultSet res = null;
    
    public DBComponentController() throws SQLException
    {
        this.stmt = this.Connect();
    }
    
    public MBLoader loadMB() throws SQLException, ComponentLoadingException
    {
        MBLoader mb = new MBLoader();
        res = mystmt.executeQuery("select * from MOTHERBOARD");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                mb.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getInt(9), res.getInt(10), res.getDouble(11));
            }   
        }
        else
        {
            throw new ComponentLoadingException();
        }   
        return mb;
            
    }
    
    public void filldbMB(String brand, String model, String socket, String formfactor , String chipset, int ramslot, String ramtype, int maxram, int tdp, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "MOTHERBOARD");
            int ress;            
            ress = mystmt.executeUpdate("insert into MOTHERBOARD (BRAND, MODEL, SOCKET_CPU, FORMFACTOR, CHIPSET, RAM_SLOTS, RAM_TYPE, RAM_MAX_GB, TDP, PRICE) values('"+brand+"', '"+model+"','"+socket+"', '"+formfactor+"', '"+chipset+"',  "+ramslot+", '"+ ramtype + "', "+ maxram+", "+tdp+", "+price+")");
    }
    
    public CPULoader loadCPU() throws SQLException, ComponentLoadingException
    {
        CPULoader cpu = new CPULoader();

            res = mystmt.executeQuery("select * from CPU");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                cpu.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6), res.getInt(7),  res.getDouble(8));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        return cpu;
    }

    public void filldbCPU(String brand, String model, String socket, Double frequency, int core, int tdp, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "CPU");
            int ress;
            ress = mystmt.executeUpdate("insert into CPU (BRAND, MODEL, CPUSOCKET, FREQUENCY, CORES, TDP, PRICE) values('"+brand+"', '"+model+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+price+")");
    }
    
    
    public RAMLoader loadRAM() throws SQLException, ComponentLoadingException
    {
        RAMLoader ram = new RAMLoader();
        res = mystmt.executeQuery("select * from RAM");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                ram.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9), res.getDouble(10));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        return ram;
    }

    public void filldbRAM(String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "RAM");
            int ress;
            ress = mystmt.executeUpdate("insert into RAM (BRAND, MODEL, RAM_TYPE, SPEED, TDP, NUMBER_OF_MODULES, SIZE_OF_MODULES, SIZE, PRICE) values('"+brand+"', '"+model+"', '"+type+"', '"+speed+"', "+tdp+", "+nom+", "+som+ ","+ size +", "+price+")");
    }
       
    public PSLoader loadPS() throws SQLException, ComponentLoadingException
    {
        PSLoader ps = new PSLoader();
        res = mystmt.executeQuery("select * from POWER_SUPPLY");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                ps.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getDouble(9));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        
        return ps;
    }

    public void filldbPS(String brand, String model, String series, String form, String efficiency ,int tdp, String modular, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "POWER_SUPPLY");
            int ress;
            ress = mystmt.executeUpdate("insert into POWER_SUPPLY (BRAND, MODEL, SERIES, FORM, EFFICIENCY, TDP, MODULAR, PRICE) values('"+brand+"', '"+model+"', '"+series+"', '"+form+"', '"+efficiency+"', "+tdp+", '"+modular+"', "+price+")");
    }
    
    public GCardLoader loadGCard() throws SQLException, ComponentLoadingException
    {
        GCardLoader gc = new GCardLoader();
        res = mystmt.executeQuery("select * from GRAPHICS_CARD");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                gc.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getDouble(7), res.getInt(8), res.getInt(9),  res.getDouble(10));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        return gc;
    }
    
    public void filldbGCard(String brand, String model, String serie, String chipset, int mem, Double clock, int tdp, int length, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "GRAPHICS_CARD");
            int ress;
            ress = mystmt.executeUpdate("insert into GRAPHICS_CARD (brand, model, series, chipset, memory, core_clock, tdp, length,price) values('"+brand+"', '"+model+"', '"+serie+"', '"+chipset+"', "+mem+", "+ clock +", "+tdp+", "+length+", "+price+")");
    }
      

    public HDriveLoader loadHDrive() throws SQLException, ComponentLoadingException
    {
        HDriveLoader hdd = new HDriveLoader();
        res = mystmt.executeQuery("select * from HDRIVE");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                hdd.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getInt(8), res.getInt(9), res.getDouble(10));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        return hdd;
    }
    
    public void filldbHDrive(String brand, String model, String serie, String form, String type, int size, int tdp, int cache, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "HDRIVE");
            int ress;
            ress = mystmt.executeUpdate("insert into HDRIVE (BRAND,MODEL,SERIE,FORM,TYPE,SIZE,TDP,CACHE,PRICE) values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+type+"', "+size+","+ tdp + ", " + cache +", "+price+")");
    }
    
    
    public CaseLoader loadCase() throws SQLException, ComponentLoadingException
    {
        CaseLoader c = new CaseLoader();
        res = mystmt.executeQuery("select * from PCCASE");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                c.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getDouble(7), res.getDouble(8));
            }
        }
        else
        {
            throw new ComponentLoadingException();
        }
        
        return c;
    }

    public void filldbCase(String brand, String model, String type, String color, String MOTHERBOARD_compatibili, Double max_hdrive_length, Double price) throws SQLException, InsertComponentException
    {
        checkExistingComponent(brand, model, "PCCASE");
        int ress;
        ress = mystmt.executeUpdate("insert into PCCASE (BRAND, MODEL, CASETYPE, COLOR, COMPATIBLE_MOTHERBOARDS, MAX_HDRIVE_LENGTH, PRICE) values('"+brand+"', '"+model+"', '"+type+"', '"+color+"', '"+MOTHERBOARD_compatibili+"', "+max_hdrive_length+", "+price+")");
    }

        
    public void removeShrt(String table, String cod) throws SQLException, DeleteComponentException
    {
            int ress;
            ress = mystmt.executeUpdate("delete from "+ table +" where COD = '"+Integer.parseInt(cod)+"'");            
            if(ress == 0) throw new DeleteComponentException();
    }
    
    public void checkExistingComponent(String brand, String model, String table) throws SQLException, InsertComponentException
    {
        String BRAND;
        String MODEL;
        res = mystmt.executeQuery("select BRAND, MODEL from " + table);
        
        while(res.next()){
            BRAND= res.getString(1).trim();
            MODEL = res.getString(2).trim();
            if(BRAND.equals(brand) && MODEL.equals(model)) throw new InsertComponentException();
        }    
    }
    
}