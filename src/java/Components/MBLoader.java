package Components;
import java.util.ArrayList;

/**
 * This class take all data of motherboard from database and insert they in ArrayLists
 * @author Utente
 */
public class MBLoader {
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> sockets = new ArrayList<>();
    private ArrayList<String> formfactors = new ArrayList<>();
    private ArrayList<String> chipsets = new ArrayList<>();
    private ArrayList<Integer> ramslots = new ArrayList<>();
    private ArrayList<String> ramtypes = new ArrayList<>();
    private ArrayList<Integer> maxrams = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    /**
     * Insert all data of motherboard into ArrayLists
     * @param cod the code of motherboard component
     * @param brand the brand of motherboard component
     * @param model the model of motherboard component
     * @param socket the socket of motherboard component
     * @param formfactor the formfactor of motherboard component
     * @param chipset the chipset of motherboard component
     * @param ramslot the number of ram supported
     * @param ramtype the type of ram supported
     * @param maxram the max size of ram supported
     * @param tdp the consumption power of motherboard component
     * @param price the price of motherboard component
     */
    public void fillLoader(int cod, String brand, String model, String socket, String formfactor , String chipset, int ramslot, String ramtype, int maxram, int tdp, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        sockets.add(socket);
        formfactors.add(formfactor);
        chipsets.add(chipset);
        ramslots.add(ramslot);
        ramtypes.add(ramtype);
        maxrams.add(maxram);
        tdps.add(tdp);       
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
        sockets.clear();
        formfactors.clear();
        chipsets.clear();
        ramslots.clear();
        maxrams.clear();
        tdps.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Get all codes of motherboard table
     * @return all codes of motherboard components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
   
     /**
     * Get all brands of motherboard table
     * @return all brands of motherboard components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Get all models of motherboard table
     * @return all models of motherboard components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
     /**
     * Get all chipsets of motherboard table
     * @return all chipsets of motherboard components
     */
    public ArrayList<String> listChipsets()
    {
        return chipsets;
    }
    
    /**
     * Get all sockets of motherboard table
     * @return all sockets of motherboard components
     */
    public ArrayList<String> listSockets()
    {
        return sockets;
    }
    
    /**
     * Get all formfactors of motherboard table
     * @return all formfactors of motherboard components
     */
    public ArrayList<String> listFormfactors()
    {
        return formfactors;
    }
    
    /**
     * Get all ramslots of motherboard table
     * @return all ramslots of motherboard components
     */
    public ArrayList<Integer> listramslots()
    {
        return ramslots;
    }
    
    /**
     * Get all maxrams of motherboard table
     * @return all maxrams of motherboard components
     */
    public ArrayList<Integer> listmaxrams()
    {
        return maxrams;
    }
    
    /**
     * Get all ramtypes of motherboard table
     * @return all ramtype of motherboard components
     */
    public ArrayList<String> listRamTypes()
    {
        return ramtypes;
    }
    
    /**
     * Get all tdps of motherboard table
     * @return all tdps of motherboard components
     */   
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    /**
     * Get all prices of motherboard table
     * @return all prices of motheroard components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the number of elements
     * @return the number of row
     */
    public int getMBSize()
    {
        return noe;
    }
    
    /**
     * Print all data of all motherboard components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            
            System.out.println(cods.get(i)+ " "+brands.get(i) + " " +models.get(i) + " " + sockets.get(i) + " " + formfactors.get(i) + " " +chipsets.get(i) + " "  + ramslots.get(i) + " " + ramtypes.get(i) + " " + maxrams.get(i) + " "+ tdps.get(i)+" "+prices.get(i));
            
        }
    }

}