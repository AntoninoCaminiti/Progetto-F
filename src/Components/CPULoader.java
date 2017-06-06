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
public class CPULoader {
    
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> sockets = new ArrayList<>();
    private ArrayList<Double> frequencies = new ArrayList<>();
    private ArrayList<Integer> cores = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Integer> qts = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    
    public void fillLoader(String brand, String model, String socket, Double frequency, int core, int tdp, int quantity, Double price)
    {
        brands.add(brand);
        models.add(model);
        sockets.add(socket);
        frequencies.add(frequency);
        cores.add(core);
        tdps.add(tdp);
        qts.add(quantity);
        prices.add(price);
        noe++;
    }
    
    public void cleanAll()
    {
        brands.clear();
        models.clear();
        sockets.clear();
        frequencies.clear();
        cores.clear();
        tdps.clear();
        qts.clear();
        prices.clear();
        noe = 0;
    }
    
    /*
    public void addBrand(String brand)
    {
        brands.add(brand);
    }
    
    public void addModel(String model)
    {
        models.add(model);
    }
    
    public void addSocket(String socket)
    {
        sockets.add(socket);
    }
    
    public void addFrequency(Double frequency)
    {
        frequencies.add(frequency);
    }
    
    public void addCore(int core)
    {
        cores.add(core);
    }
    
    
    public void addTDP(int tdp)
    {
        tdps.add(tdp);
    }
    
    
    public void addQuantity(int quantity)
    {
        qts.add(quantity);
    }
    
    public void addPrice(Double price)
    {
        prices.add(price);
    }*/
    
    
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    public ArrayList<String> listSockets()
    {
        return sockets;
    }
    
    public ArrayList<Double> listFrequencies()
    {
        return frequencies;
    }
    
    public ArrayList<Integer> listCores()
    {
        return cores;
    }
    
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    public ArrayList<Integer> listQuantities()
    {
        return qts;
    }
    
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            
            System.out.println(brands.get(i) + " " +models.get(i) +" " + sockets.get(i) + " " + frequencies.get(i) + " " + cores.get(i) + " " + tdps.get(i) + " "+ qts.get(i)+" "+prices.get(i));
            
        }
    }
    
}
