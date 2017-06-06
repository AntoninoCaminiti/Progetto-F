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
public class GCardLoader {
    
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> series = new ArrayList<>();
    private ArrayList<String> chipsets = new ArrayList<>();
    private ArrayList<Integer> memory = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Double> clocks = new ArrayList<>();
    //private ArrayList<Integer> qts = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    
    public void fillLoader(String brand, String model, String serie, String chipset, int mem, int tdp, Double clock, Double price)
    {
        brands.add(brand);
        models.add(model);
        series.add(serie);
        chipsets.add(chipset);
        memory.add(mem);
        tdps.add(tdp);
        clocks.add(clock);
        //qts.add(quantity);
        prices.add(price);
        noe++;
    }
    
    public void cleanAll()
    {
        brands.clear();
        models.clear();
        series.clear();
        chipsets.clear();
        memory.clear();
        tdps.clear();
        clocks.clear();
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
    
    public ArrayList<String> listSeries()
    {
        return series;
    }
    
    public ArrayList<String> listChipsets()
    {
        return chipsets;
    }
    
    public ArrayList<Integer> listMemory()
    {
        return memory;
    }
    
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    public ArrayList<Double> listClocks()
    {
        return clocks;
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
            
            System.out.println(brands.get(i) + " " +models.get(i) +" " + series.get(i) + " " + chipsets.get(i) + " " + memory.get(i) + " " + tdps.get(i) + " " + clocks.get(i) + " " + prices.get(i));
            
        }
    }
    
    
    
}
