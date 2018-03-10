package DatabaseElements;

import Components.CPU;
import Components.RAM;
import Exceptions.NoCPUMatchedException;
import Exceptions.NoRAMMatchedException;
import java.sql.*;
import java.util.ArrayList;

public class DBFilters {
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet res = null;
    
    /**
     * Create a statement containing the connection to the database
     * @throws SQLException if an SQL Exception occurred
     */
    public DBFilters() throws SQLException
    {
        DBConnection connection = new DBConnection();
        conn = connection.Connect();
        stmt = conn.createStatement();
    }
    
    /**
     * Get CPU data from database that have socket compatible with the socket of motherboard selected.
     * @param selectedBrand is the brand of motherboard selected
     * @param selectedModel is the model of motherboard selected
     * @return all values of cpu's component that respect the request
     * @throws SQLException if an SQL exception is occurred
     * @throws NoCPUMatchedException if no match with a CPU is found
     */
    public ArrayList filterCPU(String selectedBrand, String selectedModel) throws SQLException, NoCPUMatchedException
    {
        ArrayList <CPU> cpuArr = new ArrayList<>();
        res = stmt.executeQuery("select CPU.* from MOTHERBOARD,CPU where SOCKET_CPU=CPUSOCKET and MOTHERBOARD.BRAND = '"+ selectedBrand + "' and MOTHERBOARD.MODEL = '" + selectedModel + "'");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                 
                cpuArr.add(new CPU(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6), res.getInt(7),  res.getDouble(8)));
            }
        }
        else
        {
            throw new NoCPUMatchedException();
        }
        
        return cpuArr;
    }
    
    /**
     * Get CPU data from database that have socket compatible with the socket of motherboard selected (using only the component code).
     * @param cod the cod of motherboard selected
     * @return all values of cpu's component that respect the request
     * @throws SQLException if an SQL exception is occurred
     * @throws NoCPUMatchedException if no match with a CPU is found
     */
    public ArrayList filterCPU(String cod) throws SQLException, NoCPUMatchedException
    {
        ArrayList <CPU> cpuArr = new ArrayList<>();
        res = stmt.executeQuery("select CPU.* from MOTHERBOARD,CPU where SOCKET_CPU=CPUSOCKET and MOTHERBOARD.COD = '"+ Integer.parseInt(cod) + "'");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                 
                cpuArr.add(new CPU(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6), res.getInt(7),  res.getDouble(8)));
            }
        }
        else
        {
            throw new NoCPUMatchedException();
        }
        return cpuArr;
    }
    
    /**
     * Get RAM data from database that component speed compatible with ramtype of motherboard selected.
     * @param selectedBrand is the brand of motherboard 
     * @param selectedModel is the model of motherboard
     * @return all values of ram that respect the request
     * @throws SQLException if an SQL exception occurred
     * @throws NoRAMMatchedException if no match with a RAM is found
     */
    public ArrayList filterRAM(String selectedBrand, String selectedModel) throws SQLException, NoRAMMatchedException
    {
        ArrayList <RAM> ramArr = new ArrayList<>();
        res = stmt.executeQuery("select R1.*\n" + "from MOTHERBOARD M1, RAM R1\n" + "where M1.RAM_TYPE=R1.SPEED and M1.BRAND = '"+selectedBrand+"' and M1.MODEL = '"+selectedModel+"'\n");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                ramArr.add(new RAM(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getDouble(10)));
            }
        }
        else
        {
            throw new NoRAMMatchedException();
        }
        return ramArr;
    }
    
    /**
     * Get Ram data from database that have RamType compatible with the RamType of motherboard selected.
     * @param cod the cod of motherboard RamType selected
     * @return all values of cpu's component that respect the request
     * @throws SQLException if an SQL exception is occurred
     * @throws NoRAMMatchedException if no match with a RAM is found
     */
    public ArrayList filterRAM(String cod) throws SQLException, NoRAMMatchedException
    {
        ArrayList <RAM> ramArr = new ArrayList<>();
        res = stmt.executeQuery("select R1.*\n" + "from MOTHERBOARD M1, RAM R1\n" + "where M1.RAM_TYPE=R1.SPEED and M1.COD = "+ Integer.parseInt(cod) +"");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                ramArr.add(new RAM(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getDouble(10)));
            }
        }
        else
        {
            throw new NoRAMMatchedException();
        }
        return ramArr;
    }
}