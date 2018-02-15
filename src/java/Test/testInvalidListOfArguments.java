package Test;

import Exceptions.InvalidListOfArguments;

/**
 *
 * @author James Abbate
 */
public class testInvalidListOfArguments {
    public static void main(String[] args) {
        try{
            throw new InvalidListOfArguments();
        }
        catch(InvalidListOfArguments il)
        {
            System.err.println(il.toString());
        }
    }
}
