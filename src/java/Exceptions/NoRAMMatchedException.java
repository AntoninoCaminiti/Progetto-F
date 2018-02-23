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
public class NoRAMMatchedException extends NoComponentMatchedException {

    /**
     * Creates a new instance of <code>NoRAMMatchedException</code> without
     * detail message.
     */
    public NoRAMMatchedException() 
    {
        super("No RAM match found");
    }


}
