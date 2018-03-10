package Components;
import java.util.ArrayList;

/**
 * This class take alld data of graphics-cards and insert they in ArrayLists
 * @author Utente
 */
public class GraphicsCard extends Component {
    
    private String serie;
    private String chipset;
    private int memory;
    private Double clockSpeed;
    private int width;
    
    /**
     * @param cod the code of GC component
     * @param brand the brand of GC component
     * @param model the model of GC component
     * @param serie the series of GC component
     * @param chipset the chipset of GC component
     * @param memory the memory of GC component
     * @param clockSpeed the clock speed of GC component
     * @param tdp the consumption of power of GC component
     * @param width the length of GC component
     * @param price the price of GC component
     */
    public GraphicsCard(int cod, String brand, String model, String serie, String chipset, int memory, Double clockSpeed, int tdp, int width, Double price)
    {
        super(cod, brand, model, tdp, price);
        this.serie = serie;
        this.chipset = chipset;
        this.memory = memory;
        this.clockSpeed = clockSpeed;
        this.width = width;
    }
    
    /**
     * Take all series of GC table
     * @return all series of GC components
     */
    public String getSerie()
    {
        return serie;
    }

    /**
     * Take all chipsets of GC table
     * @return all chipsets of GC components
     */
    public String getChipset() {
        return chipset;
    }
    
    /**
     * Take all memories of GC table
     * @return all memories of GC components
     */
    public int getMemory()
    {
        return memory;
    }

    /**
     * Take all clocks of GC table
     * @return all clocks of GC components
     */
    public Double getClockSpeed()
    {
        return clockSpeed;
    }

    /**
     * Take all width of GC table
     * @return all prices of GC components
     */
    public int getWidth()
    {
        return width;
    }

    @Override
    public String getComponent()
    {
        return "GRAPHICS_CARD";
    }
    
    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Serie = " + serie +"\n");
        sb.append("Chipset = " + chipset +"\n");
        sb.append("Memory = " + memory +"\n");
        sb.append("ClockSpeed = " + clockSpeed +"\n");
        sb.append("Width = " + width);
        output = sb.toString();
        return output;
    }
}