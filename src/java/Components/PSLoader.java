package Components;
import java.util.ArrayList;

/**
 * This class take all data of powersupply from database and insert they in ArrayLists
 * @author Utente
 */
public class PSLoader {
    
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> serie = new ArrayList<>();
    private ArrayList<String> forms = new ArrayList<>();
    private ArrayList<String> efficiencies = new ArrayList<>();
    private ArrayList<Integer> maxtdps = new ArrayList<>();
    private ArrayList<String> modulars = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    /**
     * Insert all data of powersupply into ArrayLists
     * @param cod the code of PS component
     * @param brand the brand of PS component
     * @param model the model of PS component
     * @param series the series of PS component
     * @param form the form of PS component
     * @param efficiency the efficiency of PS component
     * @param tdp the max consumption of power supported
     * @param modular the modular of PS component
     * @param price the price of PS component
     */
    public void fillLoader(int cod, String brand, String model, String series, String form, String efficiency ,int tdp, String modular, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        serie.add(series);
        forms.add(form);
        efficiencies.add(efficiency);
        maxtdps.add(tdp);
        modulars.add(modular);
        prices.add(price);
        noe++;
    }
    
    /**
     * Clear all ArrayLists
     */
    public void cleanAll()
    {
        cods.clear();
        brands.clear();
        models.clear();
        serie.clear();
        forms.clear();
        efficiencies.clear();
        maxtdps.clear();
        modulars.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Get all codes of PS table
     * @return all codes of PS components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Get all brands of PS table
     * @return brands of PS components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Get all models of PS table 
     * @return all models of PS components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
     /**
     * Get all series of PS table
     * @return all series of PS components
     */
    public ArrayList<String> listSeries()
    {
        return serie;
    }
    
    /**
     * Get all forms of PS components
     * @return all forms of PS components
     */
    public ArrayList<String> listForms()
    {
        return forms;
    }
    
    /**
     * Get all efficiencies of PS table
     * @return all efficiencies of PS components
     */
    public ArrayList<String> listEfficiencies()
    {
        return efficiencies;
    }
    
    /**
     * Get all Maxtdps of PS table
     * @return all Maxtdps of PS components
     */
    public ArrayList<Integer> listMaxTDPs()
    {
        return maxtdps;
    }
    
    /**
     * Get all modulars of PS table
     * @return all modulars of PS components
     */
    public ArrayList<String> listModulars()
    {
        return modulars;
    }
    
    /**
     * Get the prices of PS table 
     * @return the prices of PS components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the number of element
     * @return te number of row
     */
    public int getSize(){
        return noe;
    }
    
    /**
     *  Print all data of all PS components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i) + " " + brands.get(i) + " " +models.get(i) + " " +serie.get(i) +" " + forms.get(i) + " " + efficiencies.get(i) + " " + maxtdps.get(i) + " " + modulars.get(i) + " "+prices.get(i));   
        }
    }
}