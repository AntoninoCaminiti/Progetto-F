/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;

/**
 *
 * @author Utente
 */
public class Watt {
    //Variable declaration:
    public int intSubTotal;
    
    //Constructor :
    
    public Watt() {
        this.intSubTotal = 0;
    }
    
    //Accessors:
     public int GetSubTotal() {
        return intSubTotal;
    }
      //Adds each item to subtotal:
    public void AddToSubTotal(int intWatt) {
        
        //Adds up subtotal
        intSubTotal += intWatt;
    }

    //Clears the calculator:
    public void ClearWatt() {
        
        intSubTotal = 0;
    }

    
    
}
