/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author user
 */
public class InsertComponentException extends Exception {

    /**
     * Creates a new instance of <code>ErrorInserComponent</code> without detail
     * message.
     */
    public InsertComponentException() {
        super("This component already exists!");
    }
    
    public String toString()
    {
        return getMessage();
    }
}