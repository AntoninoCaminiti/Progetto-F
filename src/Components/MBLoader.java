/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class MBLoader {
    
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> chipsets = new ArrayList<>();
    private ArrayList<String> sockets = new ArrayList<>();
    private ArrayList<String> formfactors = new ArrayList<>();
    private ArrayList<Integer> ramslots = new ArrayList<>();
    private ArrayList<Integer> maxrams = new ArrayList<>();
    //private ArrayList<Integer> qts = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    public void fillLoader(String brand, String model, String chipset, String socket, String formfactor ,int ramslot, int maxram, int tdp, Double price)
    {
        brands.add(brand);
        models.add(model);
        chipsets.add(chipset);
        sockets.add(socket);
        formfactors.add(formfactor);
        ramslots.add(ramslot);
        maxrams.add(maxram);
        tdps.add(tdp);
        //qts.add(quantity);
        prices.add(price);
        noe++;
    }
    
    public void cleanAll()
    {
        brands.clear();
        models.clear();
        chipsets.clear();
        sockets.clear();
        formfactors.clear();
        ramslots.clear();
        maxrams.clear();
        tdps.clear();
        //qts.clear();
        prices.clear();
        noe = 0;
    }
    
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    public ArrayList<String> listChipsets()
    {
        return chipsets;
    }
    
    public ArrayList<String> listSockets()
    {
        return sockets;
    }
    
    public ArrayList<String> listFormfactors()
    {
        return formfactors;
    }
    
    public ArrayList<Integer> listramslots()
    {
        return ramslots;
    }
    
    public ArrayList<Integer> listmaxrams()
    {
        return maxrams;
    }
    
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    /*
    public ArrayList<Integer> listQuantities()
    {
        return qts;
    }*/
    
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            
            System.out.println(brands.get(i) + " " +models.get(i) + " " +chipsets.get(i) +" " + sockets.get(i) + " " + formfactors.get(i) + " " + ramslots.get(i) + " " + maxrams.get(i) + " "+ tdps.get(i)+" "+prices.get(i));
            
        }
    }
    
}
