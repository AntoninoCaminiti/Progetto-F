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
public class RAMLoader {
    
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> speeds = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Integer> noms = new ArrayList<>();
    private ArrayList<Integer> soms = new ArrayList<>();
    private ArrayList<Integer> sizes = new ArrayList<>();
    //private ArrayList<Integer> qts = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    
    public void fillLoader(String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price)
    {
        brands.add(brand);
        models.add(model);
        types.add(type);
        speeds.add(speed);
        tdps.add(tdp);
        noms.add(nom);
        soms.add(som);
        sizes.add(size);
        //qts.add(quantity);
        prices.add(price);
        noe++;
    }
    
    public void cleanAll()
    {
        brands.clear();
        models.clear();
        types.clear();
        speeds.clear();
        tdps.clear();
        noms.clear();
        soms.clear();
        sizes.clear();
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
    
    public ArrayList<String> listTypes()
    {
        return types;
    }
    
    public ArrayList<String> listSpeeds()
    {
        return speeds;
    }
    
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    public ArrayList<Integer> listNOMs()
    {
        return noms;
    }
    
    public ArrayList<Integer> listSOMs()
    {
        return soms;
    }
    
    public ArrayList<Integer> listSizes()
    {
        return sizes;
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
            
            System.out.println(brands.get(i) + " " +models.get(i) +" " + types.get(i) + " " + speeds.get(i) + " " + tdps.get(i) + " " + noms.get(i) + " " + soms.get(i) + " " + sizes.get(i) + " " + prices.get(i));
            
        }
    }
    
}
