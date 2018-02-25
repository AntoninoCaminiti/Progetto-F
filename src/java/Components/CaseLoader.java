package Components;
import java.util.ArrayList;

/**
 * This class take all data of case and insert they in ArrayLists
 * @author Utente
 */
public class CaseLoader {
    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<String> brands = new ArrayList<>();
    private ArrayList<String> models = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();
    private ArrayList<String> mb_comp = new ArrayList<>();
    private ArrayList<Double> max_hd_len = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private int noe;
     
    /**
     * Take all data of case and insert they in ArrayLists
     * @param cod the code of case component
     * @param brand the brand of case component
     * @param model the model of case component 
     * @param type the type of case component
     * @param color the color of case component
     * @param motherboard_compatibili the type of motherboard compatible with case component
     * @param max_hdrive_lenght the max length of hdrive that case support
     * @param price the price of case component
     */
    public void fillLoader(int cod, String brand, String model, String type, String color, String motherboard_compatibili, Double max_hdrive_lenght, Double price)
    {
        cods.add(cod);
        brands.add(brand);
        models.add(model);
        types.add(type);
        colors.add(color);
        mb_comp.add(motherboard_compatibili);
        max_hd_len.add(max_hdrive_lenght);
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
        colors.clear();
        mb_comp.clear();
        max_hd_len.clear();
        prices.clear();
        noe = 0;
    }
    
    /**
     * take all codes of case table
     * @return all codes of case components
     */
    public ArrayList<Integer> listCods()
    {
        return cods;
    }
    
    /**
     * Take all brands of case table
     * @return all brands of case components
     */
    public ArrayList<String> listBrands()
    {
        return brands;
    }
    
    /**
     * Take all models of case table
     * @return all models of case components
     */
    public ArrayList<String> listModels()
    {
        return models;
    }
    
    /**
     * Take all types of case table
     * @return all types of case components
     */
    public ArrayList<String> listTypes()
    {
        return types;
    }
    
    /**
     * Take all colors of case table
     * @return all colors of case components
     */
    public ArrayList<String> listColors()
    {
        return colors;
    }
    
    /**
     * Take all MB_Comp of case table
     * @return all MB_Comp of case components
     */
    public ArrayList<String> listMB_Comp()
    {
        return mb_comp;
    }
    
    /**
     * Take all Max_hd_Len of case table
     * @return all Max_hd_Len of case components
     */
    public ArrayList<Double> listMax_hd_Len()
    {
        return max_hd_len;
    }
       
    /**
     * take all prices of case table
     * @return all prices of case components
     */
    public ArrayList<Double> listPrices()
    {
        return prices;
    }
    
    /**
     * Get the number of elelments
     * @return the number of row
     */
    public int getSize()
    {
        return noe;
    }

    /**
     * Print all data of all case components
     */
    public void printAll()
    {
        System.out.println(noe);
        for(int i = 0; i < noe; i++)
        {
            System.out.println(cods.get(i) + " " +brands.get(i) + " " +models.get(i) +" " + types.get(i) + " " + colors.get(i) + " " + mb_comp.get(i) + " " + max_hd_len.get(i) + " "+prices.get(i)); 
        }
    }
}