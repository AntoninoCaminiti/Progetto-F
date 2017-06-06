/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;

import java.util.Scanner;

/**
 *
 * @author cl427195
 */
public class Configuration {
    
    private String savedCPU;
    private String savedMB;
    private String savedGCard;
    private String savedHDrive;
    private String savedRAM;
    private String savedPS;
    
    public Configuration()
    {
        
    }
    
    
    
    public void saveCPU(String CPU)
    {
        savedCPU = CPU;
    }
    
    public String getCPU()
    {
        return savedCPU;
    }
    
    
    public void saveMB(String MB)
    {
        savedMB = MB;
    }
    
    public String getMB()
    {
        return savedMB;
    }
    
    public void savePS(String PS)
    {
        savedPS = PS;
    }
    
    public String getPS()
    {
        return savedPS;
    }
    
    public void saveGCard(String GCard)
    {
        savedGCard = GCard;
    }
    
    public String getGCard()
    {
        return savedGCard;
    }
    
    public void saveHDrive(String HDrive)
    {
        savedHDrive = HDrive;
    }
    
    public String getHDrive()
    {
        return savedHDrive;
    }
    
    public void saveRAM(String RAM)
    {
        savedRAM = RAM;
    }
    
    public String getRAM()
    {
        return savedRAM;
    }
    
    
}
