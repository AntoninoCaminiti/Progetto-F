package Components;
import java.util.ArrayList;

/**
 * This class take all data of case and insert they in ArrayLists
 * @author Utente
 */
public class PCCase extends Component {

    private String type;
    private String color;
    private String compatibleMBs;
    private Double hdLengthSupported;
     
    /**
     * Take all data of case and insert they in ArrayLists
     * @param cod the code of case component
     * @param brand the brand of case component
     * @param model the model of case component 
     * @param type the type of case component
     * @param color the color of case component
     * @param compatibleMBs the type of motherboard compatible with case component
     * @param hdLengthSuppported the max length of hdrive that case support
     * @param price the price of case component
     */
    public PCCase(int cod, String brand, String model, String type, String color, String compatibleMBs, Double hdLengthSupported, Double price)
    {
        super(cod, brand, model, 0, price);
        this.type = type;
        this.color = color;
        this.compatibleMBs = compatibleMBs;
        this.hdLengthSupported = hdLengthSupported;
    }
    /**
     * Take all types of case table
     * @return all types of case components
     */
    public String getType()
    {
        return type;
    }

    /**
     * Take all colors of case table
     * @return all colors of case components
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Take all compatible motherboards of case table
     * @return all compatible motherboards of case components
     */
    public String getCompatibleMBs()
    {
        return compatibleMBs;
    }

    /**
     * Take all max hard disk physic size of case table
     * @return all max hard disk physic size of case components
     */
    public Double getHdLengthSupported()
    {
        return hdLengthSupported;
    }

    @Override
    public String getComponent()
    {
        return "PCCASE";
    }
    
    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Type = " + type + "\n");
        sb.append("Color = " + color + "\n");
        sb.append("Compatible motherboards = " + compatibleMBs + "\n");
        sb.append("Hard drive maximum length supported = " + hdLengthSupported + "\n");
        output = sb.toString();
        return output;
    }

    
}