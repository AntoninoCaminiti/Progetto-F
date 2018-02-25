package Components;
import java.util.ArrayList;

/**
 * This class take all data of cpu from database and insert they in ArrayLists
 * @author Utente
 */
public class CPULoader {
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> sockets = new ArrayList<>();
    private ArrayList<Double> frequencies = new ArrayList<>();
    private ArrayList<Integer> cores = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
      
    /**
     * Take all data from CPU  and insert they in ArrayLists
     * @param cod the code of cpu component
     * @param brand the brand of cpu component
     * @param model the model of cpu component
     * @param socket the socket of cpu component
     * @param frequency the frequency of cpu component
     * @param core the cores of cpu component
     * @param tdp the consumption power of cpu component
     * @param price the price of cpu component
     */
    public void fillLoader(int cod, String brand, String model, String socket, Double frequency, int core, int tdp, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        sockets.add(socket);
        frequencies.add(frequency);
        cores.add(core);
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
        frequencies.clear();
        cores.clear();
        tdps.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Take all brands of cpu table
     * @return all brands of cpu components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Take al models of cpu table
     * @return all models of cpu components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    /**
     * Take all sockets of cpu table
     * @return all sockets of cpu components
     */
    public ArrayList<String> listSockets()
    {
        return sockets;
    }
    
    /**
     * Take all frequencies of cpu table
     * @return all frequencies of cpu components
     */
    public ArrayList<Double> listFrequencies()
    {
        return frequencies;
    }
    
    /**
     * Take all cores of cpu table
     * @return all cores of cpu components
     */
    public ArrayList<Integer> listCores()
    {
        return cores;
    }
    
    /**
     * Take all tdps of cpu table
     * @return all tdps of cpu components
     */
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
  
    /**
     * Take all prices of cpu table
     * @return all prices of cpu components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Take all codes of cpu table
     * @return all codes of cpu components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Get the number of elements
     * @return the number of elements, the number of row
     */ 
    public int getSize()
    {
        return noe;
    }

    /**
     * Print all data of all cpu components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i)+ " " + brands.get(i) + " " +models.get(i) +" " + sockets.get(i) + " " + frequencies.get(i) + " " + cores.get(i) + " " + tdps.get(i) + " "+prices.get(i));
        }
    }
}