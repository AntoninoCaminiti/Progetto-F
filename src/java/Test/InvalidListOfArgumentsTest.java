package Test;

import Exceptions.InvalidListOfArgumentsException;

/**
 *
 * @author James Abbate
 */
public class InvalidListOfArgumentsTest {
    public static void main(String[] args) {
        try{
            throw new InvalidListOfArgumentsException();
        }
        catch(InvalidListOfArgumentsException il)
        {
            System.err.println(il.toString());
        }
    }
}
