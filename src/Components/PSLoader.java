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
public class PSLoader {
    
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> series = new ArrayList<>();
    private ArrayList<String> forms = new ArrayList<>();
    private ArrayList<String> efficiencies = new ArrayList<>();
    private ArrayList<Integer> maxtdps = new ArrayList<>();
    private ArrayList<String> modulars = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    public void fillLoader(String brand, String model, String serie, String form, String efficiency ,int maxtdp, String modular, Double price)
    {
        brands.add(brand);
        models.add(model);
        series.add(serie);
        forms.add(form);
        efficiencies.add(efficiency);
        maxtdps.add(maxtdp);
        modulars.add(modular);
        prices.add(price);
        noe++;
    }
    
    
    public void cleanAll()
    {
        brands.clear();
        models.clear();
        series.clear();
        forms.clear();
        efficiencies.clear();
        maxtdps.clear();
        modulars.clear();
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
    
    public ArrayList<String> listForms()
    {
        return forms;
    }
    
    public ArrayList<String> listEfficiencies()
    {
        return efficiencies;
    }
    
    public ArrayList<Integer> listMaxTDPs()
    {
        return maxtdps;
    }
    
    public ArrayList<String> listModulars()
    {
        return modulars;
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
            
            System.out.println(brands.get(i) + " " +models.get(i) + " " +series.get(i) +" " + forms.get(i) + " " + efficiencies.get(i) + " " + maxtdps.get(i) + " " + modulars.get(i) + " "+prices.get(i));
            
        }
    }
    
}
