/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD;

/**
 *
 * @author user
 */
public class TestQuery {
    
    public static void main(String[] args)
    {
        System.out.println("insert into hdrive values('"+"brand"+"', '"+"model"+"', '"+"serie"+"', '"+"form"+"', '"+"type"+"', "+"size"+","+ "tdp" + ", " + "cache" +", "+"price"+")");
        System.out.println("delete from cpu where brand = '"+"brand"+"' and model = '"+"model"+"' and socket = '"+"socket"+"' and frequency = "+"frequency"+" and cores = "+"core"+" and tdp = "+"tdp"+" and price = "+"price"+")");
    }
    
}
