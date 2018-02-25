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
    
    /**
     * Create a statement containing the connection to the database
     * @throws SQLException if an SQL Exception occurred
     */
    public DBComponentController() throws SQLException
    {
        this.stmt = this.Connect();
    }
    
    /**
    * Get data of Motherboard from DataBase
    * @throws SQLException if an SQL exception is occurred 
    * @throws ComponentLoadingException if a component could not be loaded
    * @return MBLoader the local object of the component gets returned in order to be assigned to an actual object
    */
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
    
    /**
     * Insert motherboard data in the database
     * @param brand attribute of motherboard it's the brand of component
     * @param model attribute of motherboard it's the model of component
     * @param socket attribute of motherboard it's the socket of component
     * @param formfactor attribute of motherboard it's the formfactor of component
     * @param chipset attribute of motherboard it's the chipset of component
     * @param ramslot attribute of motherboard it's the number of ram supported of component
     * @param ramtype attribute of motherboard it's the type of ram supported of component
     * @param maxram attribute of motherboard it's the size of ram supported of component
     * @param tdp attribute of motherboard it's the power consumption of component
     * @param price attribute of motherboard it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbMB(String brand, String model, String socket, String formfactor , String chipset, int ramslot, String ramtype, int maxram, int tdp, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "MOTHERBOARD");
            int ress;            
            ress = mystmt.executeUpdate("insert into MOTHERBOARD (BRAND, MODEL, SOCKET_CPU, FORMFACTOR, CHIPSET, RAM_SLOTS, RAM_TYPE, RAM_MAX_GB, TDP, PRICE) values('"+brand+"', '"+model+"','"+socket+"', '"+formfactor+"', '"+chipset+"',  "+ramslot+", '"+ ramtype + "', "+ maxram+", "+tdp+", "+price+")");
    }
    
    /**
     * Get data of CPU from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return CPULoader the local object of the component gets returned in order to be assigned to an actual object
     */
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

    /**
     * Insert cpu data in the database
     * @param brand attribute of Cpu it's the brand of component
     * @param model attribute of Cpu it's the model of component
     * @param socket attribute of Cpu it's the socket of component
     * @param frequency attribute of Cpu it's the frequency of component
     * @param core attribute of Cpu it's the number of cores of component
     * @param tdp attribute of Cpu it's the power consumption of component
     * @param price attribute of Cpu it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbCPU(String brand, String model, String socket, Double frequency, int core, int tdp, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "CPU");
            int ress;
            ress = mystmt.executeUpdate("insert into CPU (BRAND, MODEL, CPUSOCKET, FREQUENCY, CORES, TDP, PRICE) values('"+brand+"', '"+model+"', '"+socket+"', "+frequency+", "+core+", "+tdp+", "+price+")");
    }
    
    /**
     * Get data of RAM from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return RAMLoader the local object of the component gets returned in order to be assigned to an actual object
     */
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

    /**
     * Insert ram data in the database
     * @param brand attribute of ram it's the brand of component
     * @param model attribute of ram it's the model of component
     * @param type attribute of ram it's the type of component
     * @param speed attribute of ram it's the speed of component
     * @param tdp attribute of ram it's the power consumption of component
     * @param nom attribute of ram it's the number of modular of component
     * @param som attribute of ram it's the size of modular of component
     * @param size attribute of ram it's the size of component
     * @param price attribute of ram it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbRAM(String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "RAM");
            int ress;
            ress = mystmt.executeUpdate("insert into RAM (BRAND, MODEL, RAM_TYPE, SPEED, TDP, NUMBER_OF_MODULES, SIZE_OF_MODULES, SIZE, PRICE) values('"+brand+"', '"+model+"', '"+type+"', '"+speed+"', "+tdp+", "+nom+", "+som+ ","+ size +", "+price+")");
    }
       
    /**
     * Get data of Power Supply from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return PSLoader the local object of the component gets returned in order to be assigned to an actual object
     */
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

    /**
     * Insert powersupply data in the database
     * @param brand attribute of powersupply it's the brand of component
     * @param model attribute of powersupply it's the model of component
     * @param series attribute of powersupply it's the series of component
     * @param form attribute of powersupply it's the form of component
     * @param efficiency attribute of powersupply it's the efficiency of component
     * @param tdp attribute of powersupply it's the power supported of component
     * @param modular attribute of powersupply it's the modular of component
     * @param price attribute of powersupply it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbPS(String brand, String model, String series, String form, String efficiency ,int tdp, String modular, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "POWER_SUPPLY");
            int ress;
            ress = mystmt.executeUpdate("insert into POWER_SUPPLY (BRAND, MODEL, SERIES, FORM, EFFICIENCY, TDP, MODULAR, PRICE) values('"+brand+"', '"+model+"', '"+series+"', '"+form+"', '"+efficiency+"', "+tdp+", '"+modular+"', "+price+")");
    }
    
    /**
     * Get data of Graphics Card from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return GCardLoader the local object of the component gets returned in order to be assigned to an actual object
     */
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
    
    /**
     * Insert graphics-card data in the database
     * @param brand attribute of graphics-card it's the brand of component
     * @param model attribute of graphics-card it's the model of component
     * @param serie attribute of graphics-card it's the series of component
     * @param chipset attribute of graphics-card it's the chipset of component
     * @param mem attribute of graphics-card it's the memory of component
     * @param clock attribute of graphics-card it's the clock of component
     * @param tdp attribute of graphics-card it's the power consumption of component
     * @param length attribute of graphics-card it's the length of component
     * @param price attribute of graphics-card it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbGCard(String brand, String model, String serie, String chipset, int mem, Double clock, int tdp, int length, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "GRAPHICS_CARD");
            int ress;
            ress = mystmt.executeUpdate("insert into GRAPHICS_CARD (brand, model, series, chipset, memory, core_clock, tdp, length,price) values('"+brand+"', '"+model+"', '"+serie+"', '"+chipset+"', "+mem+", "+ clock +", "+tdp+", "+length+", "+price+")");
    }
      
    /**
     * Get data of HardDrive from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return HDriveLoader the local object of the component gets returned in order to be assigned to an actual object
     */
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
    
    /**
     * Insert hard drive data in the database
     * @param brand attribute of hard drive it's the brand of component
     * @param model attribute of hard drive it's the model of component
     * @param serie attribute of hard drive it's the series of component
     * @param form  attribute of hard drive it's the form of component
     * @param type  attribute of hard drive it's the type of component
     * @param size  attribute of hardrive it's the size of component
     * @param tdp   attribute of hard drive it's the power consumption of component
     * @param cache attribute of hard drive it's the cache of component
     * @param price attribute of hard drive it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbHDrive(String brand, String model, String serie, String form, String type, int size, int tdp, int cache, Double price) throws SQLException, InsertComponentException
    {
            checkExistingComponent(brand, model, "HDRIVE");
            int ress;
            ress = mystmt.executeUpdate("insert into HDRIVE (BRAND,MODEL,SERIE,FORM,TYPE,SIZE,TDP,CACHE,PRICE) values('"+brand+"', '"+model+"', '"+serie+"', '"+form+"', '"+type+"', "+size+","+ tdp + ", " + cache +", "+price+")");
    }
    
    /**
     * Get data of Case from DataBase
     * @throws SQLException if an SQL exception is occurred 
     * @throws ComponentLoadingException if a component could not be loaded
     * @return CaseLoader the local object of the component gets returned in order to be assigned to an actual object
     */
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

    /**
     * Insert case data in the database
     * @param brand attribute of case it's the brand of component
     * @param model attribute of case it's the model of component
     * @param type  attribute of case it's the type of component
     * @param color attribute of case it's the color of component
     * @param MOTHERBOARD_compatibili attribute of case it's the compatible motherboard of component
     * @param max_hdrive_length attribute of case it's the maximum hdrive length supported by component
     * @param price attribute of case it's the price of component
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException propagated from checkExistingComponent
     */
    public void filldbCase(String brand, String model, String type, String color, String MOTHERBOARD_compatibili, Double max_hdrive_length, Double price) throws SQLException, InsertComponentException
    {
        checkExistingComponent(brand, model, "PCCASE");
        int ress;
        ress = mystmt.executeUpdate("insert into PCCASE (BRAND, MODEL, CASETYPE, COLOR, COMPATIBLE_MOTHERBOARDS, MAX_HDRIVE_LENGTH, PRICE) values('"+brand+"', '"+model+"', '"+type+"', '"+color+"', '"+MOTHERBOARD_compatibili+"', "+max_hdrive_length+", "+price+")");
    }

     /**
     * Remove an element from database 
     * @param table name of table that contains element 
     * @param cod code of element 
     * @throws SQLException if an SQL exception is occurred
     * @throws DeleteComponentException if a component could not be removed
     */  
    public void removeShrt(String table, String cod) throws SQLException, DeleteComponentException
    {
            int ress;
            ress = mystmt.executeUpdate("delete from "+ table +" where COD = '"+Integer.parseInt(cod)+"'");            
            if(ress == 0) throw new DeleteComponentException();
    }
    
    /**
     * Check if the component already exists
     * @param brand brand of component
     * @param model model of component
     * @param table name of table thtat contains element
     * @throws SQLException if an SQL exception is occurred
     * @throws InsertComponentException if a component could not be inserted
     */
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