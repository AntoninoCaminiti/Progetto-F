package Components;
import java.util.ArrayList;

/**
 * This class take all data of HD from database and insert they in ArrayLists
 * @author Utente
 */
public class MemoryDrive extends Component {
    
    private String serie;
    private String form;
    private String type;
    private int size;
    private int cache;
    
    /**
     * @param cod the code of HD component
     * @param brand the brand of HD component
     * @param model the model of HD component
     * @param serie the series of HD component
     * @param form the form of HD component
     * @param type the type of HD component
     * @param size the size of HD component
     * @param tdp the consumption power of HD component
     * @param cache the cache of HD component
     * @param price the price of HD component
     */
    public MemoryDrive(int cod, String brand, String model, String serie, String form, String type, int size, int tdp, int cache, Double price)
    {
        super(cod, brand, model, tdp, price);
        this.serie = serie;
        this.form = form;
        this.type = type;
        this.size = size;
        this.cache = cache;
    }
    
    /**
     * Take all series of HD table
     * @return all series of HD components
     */
    public String getSerie()
    {
        return serie;
    }

    /**
     * Take all forms of HD table
     * @return all forms of HD components
     */
    public String getForm()
    {
        return form;
    }

    /**
     * Take all types of HD table
     * @return all types of HD components
     */
    public String getType()
    {
        return type;
    }

    /**
     * Take all sizes of HD table
     * @return all sizes of HD components
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Take all caches of HD table
     * @return all caches of HD components
     */
    public int getCache()
    {
        return cache;
    }
    
    @Override
    public String getComponent()
    {
        return "HDRIVE";
    }

    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Serie = " + serie + "\n");
        sb.append("Form = " + form + "\n");
        sb.append("Type = " + type + "\n");
        sb.append("Size = " + size + "\n");
        sb.append("Cache = " + cache + "\n");
        output = sb.toString();
        return output;
    }
}