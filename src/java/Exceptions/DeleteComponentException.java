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
public class DeleteComponentException extends Exception {

    /**
     * Creates a new instance of <code>DeleteComponentError</code> without
     * detail message.
     */
    public DeleteComponentException() {
        super("Error in deleting component. Component may not exist");
    }

}
