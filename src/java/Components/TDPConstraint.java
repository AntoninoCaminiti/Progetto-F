/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

/**
 *
 * @author root
 */
public class TDPConstraint implements Constraints{
    
    private UserCart uc1;
    private int totalTDP;
    
    @Override
    public Boolean isCompatible(UserCart uc1)
    {
        this.uc1 = uc1;
        System.out.println(uc1.getGraphics().getTdp()+uc1.getCpupc().getTdp());
        System.out.println(uc1.getPowersupp().getMaxTDPSupported());
        int sumOfTDP = uc1.getMotherboard().getTdp() + uc1.getCpupc().getTdp()+uc1.getMemoryram().getTdp()+uc1.getGraphics().getTdp()+uc1.getMemdrive().getTdp();
        
        
        
        if(sumOfTDP<uc1.getPowersupp().getMaxTDPSupported())
        {
            return true;
        }
        return false;
    }
    
}
