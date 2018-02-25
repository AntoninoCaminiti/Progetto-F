package Components;
import java.util.ArrayList;

/**
 * This class take alld data of graphics-cards and insert they in ArrayLists
 * @author Utente
 */
public class GCardLoader {
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> series = new ArrayList<>();
    private ArrayList<String> chipsets = new ArrayList<>();
    private ArrayList<Integer> memory = new ArrayList<>();
    private ArrayList<Double> clocks = new ArrayList<>();
    private ArrayList<Integer> tdps = new ArrayList<>();
    private ArrayList<Integer> length = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
    
    /**
     * Take all data of GC and insert they in ArreyLists
     * @param cod the code of GC component
     * @param brand the brand of GC component
     * @param model the model of GC component
     * @param serie the series of GC component
     * @param chipset the chipset of GC component
     * @param mem the memory of GC component
     * @param clock the clock of GC component
     * @param tdp the consumption of power of GC component
     * @param len the length of GC component
     * @param price the price of GC component
     */
    public void fillLoader(int cod, String brand, String model, String serie, String chipset, int mem, Double clock, int tdp, int len, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        series.add(serie);
        chipsets.add(chipset);
        memory.add(mem);
        clocks.add(clock);
        tdps.add(tdp);
        length.add(len);
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
        series.clear();
        chipsets.clear();
        memory.clear();
        clocks.clear();
        tdps.clear();
        length.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * Take all codes of GC table
     * @return all codes of GC components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Take all brands of GC table
     * @return all brands of GC components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Take all models of Gcs table
     * @return all models of GC components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    /**
     * Take all series of GC table
     * @return all series of GC components
     */
    public ArrayList<String> listSeries()
    {
        return series;
    }
    
    /**
     * Take all chipsets of GC table
     * @return all chipsets of GC components
     */
    public ArrayList<String> listChipsets()
    {
        return chipsets;
    }
    
    /**
     * Take all memories of GC table
     * @return all memories of GC components
     */
    public ArrayList<Integer> listMemory()
    {
        return memory;
    }
    
    /**
     * Take all clocks of GC table
     * @return all clocks of GC components
     */
    public ArrayList<Double> listClocks()
    {
        return clocks;
    }
    
    /**
     * Take all TDPs of GC table
     * @return all TDPs of GC components
     */
    public ArrayList<Integer> listTDPs()
    {
        return tdps;
    }
    
    /**
     * Take all prices of GC table
     * @return all prices of GC components
     */
    public ArrayList<Integer> listLength()
    {
        return length;
    }
    
    /**
     * Take all prices of GC table
     * @return all prices of GC components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the number of elements
     * @return the nuber of row
     */
    public int getSize()
    {
        return noe;
    }
     
    /**
     * Print al data of GC components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i)+ " " + brands.get(i) + " " +models.get(i) +" " + series.get(i) + " " + chipsets.get(i) + " " + memory.get(i) + " " + clocks.get(i) + " " + tdps.get(i) + " " + length.get(i) +  " " + prices.get(i));   
        }
    }
}