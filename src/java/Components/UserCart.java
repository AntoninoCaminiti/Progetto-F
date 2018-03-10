/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.text.DecimalFormat;

/**
 *
 * @author root
 */
public class UserCart {
    
    private Motherboard motherboard;
    private CPU cpupc;
    private RAM memoryram;
    private GraphicsCard graphics;
    private MemoryDrive memdrive;
    private PowerSupply powersupp;
    private PCCase casesac;
    
    
    
    public UserCart()
    {
        
    }
    
    public void addComponents(Motherboard mob, CPU proc, RAM ramar, GraphicsCard graphs, MemoryDrive mdrive, PowerSupply psupp, PCCase pccp)
    {
        setMotherboard(mob);
        setCpupc(proc);
        setMemoryram(ramar);
        setGraphics(graphs);
        setMemdrive(mdrive);
        setPowersupp(psupp);
        setCasesac(pccp);
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public CPU getCpupc() {
        return cpupc;
    }

    public void setCpupc(CPU cpupc) {
        this.cpupc = cpupc;
    }

    public RAM getMemoryram() {
        return memoryram;
    }

    public void setMemoryram(RAM memoryram) {
        this.memoryram = memoryram;
    }

    public GraphicsCard getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsCard graphics) {
        this.graphics = graphics;
    }

    public MemoryDrive getMemdrive() {
        return memdrive;
    }

    public void setMemdrive(MemoryDrive memdrive) {
        this.memdrive = memdrive;
    }

    public PowerSupply getPowersupp() {
        return powersupp;
    }

    public void setPowersupp(PowerSupply powersupp) {
        this.powersupp = powersupp;
    }

    public PCCase getCasesac() {
        return casesac;
    }

    public void setCasesac(PCCase casesac) {
        this.casesac = casesac;
    }


    public Double getTotalPrice()
    {
        return motherboard.getPrice() + cpupc.getPrice() + memoryram.getPrice() + graphics.getPrice() + memdrive.getPrice() + powersupp.getPrice() + casesac.getPrice();
    }
    
    public int getTotalTDP()
    {
        return motherboard.getTdp() + cpupc.getTdp() + memoryram.getTdp() + graphics.getTdp() + memdrive.getTdp();
    }
    
    public String getTotPrice()
    {
        Double tot = motherboard.getPrice() + cpupc.getPrice() + memoryram.getPrice() + graphics.getPrice() + memdrive.getPrice() + powersupp.getPrice() + casesac.getPrice();
        DecimalFormat pricef = new DecimalFormat("#0.00 €");
        return pricef.format(tot);
    }
}
