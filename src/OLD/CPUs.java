/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD;

import java.util.ArrayList;

/**
 *
 * @author cl427263
 */
public class CPUs extends Components {
    
    private ArrayList<Double> clock = new ArrayList<>();
    
    
    public CPUs(ArrayList<String> brand, ArrayList<String> model, ArrayList<String> socket, ArrayList<String> chipset, ArrayList<Double> freq, ArrayList<Integer> quantity, ArrayList<Integer> cores, ArrayList<Integer> tdp)
    {
        super(brand, quantity);
        clock = freq;
    }
    
    
  
    public Double getClock(String names)
    {
        Double freq = 0.0;
        int indx;
        
            if(name.contains(names))
                    {
                        
                        indx = name.indexOf(names);
                        freq = this.clock.get(indx);
                    }
            else
            {
                System.out.println("No CPU matching for this frequency.");
                System.exit(0);
            }
            
            return freq;
    }
    
}
