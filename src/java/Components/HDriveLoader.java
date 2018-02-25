package Components;
import java.util.ArrayList;

/**
 * This class take all data of HD from database and insert they in ArrayLists
 * @author Utente
 */
public class HDriveLoader {
    
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> serie = new ArrayList<>();
    private ArrayList<String> forms = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<Integer> sizes = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Integer> caches = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    /**
     * Insert all HD data into arraylist
     * @param cod the code of HD component
     * @param brand the brand of HD component
     * @param model the model of HD component
     * @param series the series of HD component
     * @param form the form of HD component
     * @param type the type of HD component
     * @param size the size of HD component
     * @param tdp the consumption power of HD component
     * @param cache the cache of HD component
     * @param price the price of HD component
     */
    public void fillLoader(int cod, String brand, String model, String series, String form, String type, int size, int tdp, int cache, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        serie.add(series);
        forms.add(form);
        types.add(type);
        sizes.add(size);
        tdps.add(tdp);
        caches.add(cache);
        prices.add(price);
        noe++;
    }
    
    /**
     * clear all ArrayLists
     */
    public void cleanAll()
    {
        cods.clear();
        brands.clear();
        models.clear();
        serie.clear();
        forms.clear();
        types.clear();
        sizes.clear();
        tdps.clear();
        caches.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Take all codes of HD table
     * @return all codes of HD components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Take all brands of HD table
     * @return all brands of HD components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Take all models of HD table
     * @return all models of HD components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    /**
     * Take all series of HD table
     * @return all series of HD components
     */
    public ArrayList<String> listSeries()
    {
        return serie;
    }
    
    /**
     * Take all forms of HD table
     * @return all forms of HD components
     */
    public ArrayList<String> listForms()
    {
        return forms;
    }
    
    /**
     * Take all types of HD table
     * @return all types of HD components
     */
    public ArrayList<String> listTypes()
    {
        return types;
    }
    
    /**
     * Take all sizes of HD table
     * @return all sizes of HD components
     */
    public ArrayList<Integer> listSizes()
    {
        return sizes;
    }
    
    /**
     * Take all TDPs of HD table 
     * @return all TDPs of HD components
     */
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    /**
     * Take all caches of HD table
     * @return all caches of HD components
     */
    public ArrayList<Integer> listCaches()
    {
        return caches;
    }
    
    /**
     * Take all prices of HD table
     * @return all prices of HD components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the number of element
     * @return the number of row
     */
    public int getSize()
    {
        return noe;
    }
    
    /**
     * Print all data of HD components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i) + " " + brands.get(i) + " " + models.get(i) +" " + serie.get(i) + " " + forms.get(i) + " " + types.get(i) + " " + sizes.get(i) + " " + tdps.get(i) + " " + caches.get(i) + " " + prices.get(i));
        }
    }
    
}