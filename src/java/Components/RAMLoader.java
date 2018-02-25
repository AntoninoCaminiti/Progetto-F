package Components;
import java.util.ArrayList;

/**
 * This class take all data of ram from database and insert they in ArrayLists
 * @author Utente
 */
public class RAMLoader {
    
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> speeds = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Integer> noms = new ArrayList<>();
    private ArrayList<Integer> soms = new ArrayList<>();
    private ArrayList<Integer> sizes = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    /**
     * Insert all data of ram into ArrayLists
     * @param cod the code of ram component
     * @param brand the brand of ram component
     * @param model the model of ram component
     * @param type the type of ram component
     * @param speed the speed of ram component
     * @param tdp the consumptionpower of ram component
     * @param nom the number of modular of ram component
     * @param som the size of modular of ram component
     * @param size the size of ram component
     * @param price the price of ram component
     */
    public void fillLoader(int cod, String brand, String model, String type, String speed, int tdp, int nom, int som, int size, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        types.add(type);
        speeds.add(speed);
        tdps.add(tdp);
        noms.add(nom);
        soms.add(som);
        sizes.add(size);
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
        types.clear();
        speeds.clear();
        tdps.clear();
        noms.clear();
        soms.clear();
        sizes.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Get all codes of ram table
     * @return all codes of ram components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Get all brands of ram table
     * @return all brands of ram components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Get all models of ram table
     * @return all models of ram components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
     /**
     * Get all types of ram table
     * @return all tupes of ram components
     */
    public ArrayList<String> listTypes()
    {
        return types;
    }
    
    /**
     * Get all speeds of ram table
     * @return all speeds of ram components
     */
    public ArrayList<String> listSpeeds()
    {
        return speeds;
    }
     /**
     * Get all tdps of ram table
     * @return all tdps of ram components
     */
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    /**
     * Get all NOMs of ram table
     * @return all NOMs of ram components
     */
    public ArrayList<Integer> listNOMs()
    {
        return noms;
    }
    
    /**
     * Get all SOMs of ram table 
     * @return all SOMs of ram components
     */
    public ArrayList<Integer> listSOMs()
    {
        return soms;
    }
    
    /**
     * Get all sizes of ram table
     * @return all size of ram components
     */
    public ArrayList<Integer> listSizes()
    {
        return sizes;
    }
    
    /**
     * Get all prices of ram table
     * @return all prices of ram components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the numer of element
     * @return the number of row
     */
    public int getSize()
    {
        return noe;
    }
    
    /**
     * Print all data of all ram components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i) + " " + brands.get(i) + " " +models.get(i) +" " + types.get(i) + " " + speeds.get(i) + " " + tdps.get(i) + " " + noms.get(i) + " " + soms.get(i) + " " + sizes.get(i) + " " + prices.get(i)); 
        }
    }
}