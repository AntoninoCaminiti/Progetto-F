/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class UserConfigurations {
    
    private ArrayList <UserCart> save;
    private int numberOfConfs;
    private String username;
    
    public UserConfigurations(String username)
    {
        save = new ArrayList<>();
        numberOfConfs = 0;
        this.username = username;
    }
    
    public void addSavedConfiguration(Motherboard mob, CPU proc, RAM ramar, GraphicsCard graphs, MemoryDrive mdrive, PowerSupply psupp, PCCase pccp)
    {
        UserCart uc = new UserCart();
        uc.addComponents(mob,proc,ramar,graphs,mdrive,psupp,pccp);
        save.add(uc);
        numberOfConfs++;
    }

    public int getNumberOfConfs() {
        return numberOfConfs;
    }

    public ArrayList<UserCart> getSave() {
        return save;
    }
    
    
    
}
