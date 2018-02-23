package Exceptions;


public class InvalidListOfArgumentsException extends Exception {

    
    public InvalidListOfArgumentsException() {
        
        super("One or more arguments are missing.");
    }

    
    public String toString () {
        return getMessage();
    }

}
