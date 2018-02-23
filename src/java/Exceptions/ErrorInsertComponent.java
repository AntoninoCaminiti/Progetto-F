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
public class ErrorInsertComponent extends Exception {

    /**
     * Creates a new instance of <code>ErrorInserComponent</code> without detail
     * message.
     */
    public ErrorInsertComponent() {
        super("This component already exists! Wait a second.. You will be automatically redirected to the correct page..");
    }
    
    public String toString()
    {
        return getMessage();
    }
}