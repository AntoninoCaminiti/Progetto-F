/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD;

import java.util.ArrayList;





public abstract class Components {
    
        
    
    protected ArrayList<String> name = new ArrayList<>();
    protected ArrayList<Integer> price = new ArrayList<>();
    
    
    public Components(ArrayList<String> names, ArrayList<Integer> prices)
    {
        name = names;
        price = prices;
    }
    
    public void addCPU(String name, int price)
    {
        this.name.add(name);
        this.price.add(price);
    }


    
    
    
    public int getPrice(String name)
    {
        int pr = 0;
        int indx;
        
            if(this.name.contains(name))
                    {
                        
                        indx = this.name.indexOf(name);
                        pr = this.price.get(indx);
                    }
       
        
        return pr;
    }
    
    
}
