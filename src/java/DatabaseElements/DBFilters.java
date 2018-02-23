package DatabaseElements;

import Components.CPULoader;
import Components.MBLoader;
import Components.RAMLoader;
import Exceptions.NoCPUMatchedException;
import Exceptions.NoRAMMatchedException;
import java.sql.*;

public class DBFilters extends DBConnection {
    
    private Statement stmt = null;
    private ResultSet res = null;
    
    public DBFilters() throws SQLException
    {
        stmt = this.Connect();       
    }
    
    public CPULoader filterCPU(String selectedBrand, String selectedModel) throws SQLException, NoCPUMatchedException
    {
        CPULoader cpu = new CPULoader();
        res = stmt.executeQuery("select CPU.* from MOTHERBOARD,CPU where SOCKET_CPU=CPUSOCKET and MOTHERBOARD.BRAND = '"+ selectedBrand + "' and MOTHERBOARD.MODEL = '" + selectedModel + "'");
        
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                 
                cpu.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6), res.getInt(7),  res.getDouble(8));
            }
        }
        else
        {
            throw new NoCPUMatchedException();
        }
        
        return cpu;
    }
    
    public CPULoader filterCPU(String cod) throws SQLException, NoCPUMatchedException
    {
        CPULoader cpu = new CPULoader();
        res = stmt.executeQuery("select CPU.* from MOTHERBOARD,CPU where SOCKET_CPU=CPUSOCKET and MOTHERBOARD.COD = '"+ Integer.parseInt(cod) + "'");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                 
                cpu.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getInt(6), res.getInt(7),  res.getDouble(8));
            }
        }
        else
        {
            throw new NoCPUMatchedException();
        }
        return cpu;
    }
    
    public RAMLoader filterRAM(String selectedBrand, String selectedModel) throws SQLException, NoRAMMatchedException
    {
        RAMLoader r = new RAMLoader();
        res = stmt.executeQuery("select R1.*\n" + "from MOTHERBOARD M1, RAM R1\n" + "where M1.RAM_TYPE=R1.SPEED and M1.BRAND = '"+selectedBrand+"' and M1.MODEL = '"+selectedModel+"'\n");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                r.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9), res.getDouble(10));
            }
        }
        else
        {
            throw new NoRAMMatchedException();
        }
        return r;
    }
    
    public RAMLoader filterRAM(String cod) throws SQLException, NoRAMMatchedException
    {
        RAMLoader r = new RAMLoader();
        res = stmt.executeQuery("select R1.*\n" + "from MOTHERBOARD M1, RAM R1\n" + "where M1.RAM_TYPE=R1.SPEED and M1.COD = "+ Integer.parseInt(cod) +"");
        if(res.isBeforeFirst())
        {
            while(res.next())
            {
                r.fillLoader(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8), res.getInt(9), res.getDouble(10));
            }
        }
        else
        {
            throw new NoRAMMatchedException();
        }
        return r;
    }
}