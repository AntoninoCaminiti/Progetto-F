/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
    * @author root
 */
public class NoComponentMatchedException extends Exception{

    public NoComponentMatchedException() {
        super("No matching component found");
    }
    
    public NoComponentMatchedException(String msg) {
        super(msg);
    }
    
}
