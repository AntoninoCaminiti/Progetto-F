package Components;
import java.util.ArrayList;

/**
 * This class take all data of ram from database and insert they in ArrayLists
 * @author Utente
 */
public class RAM extends Component {
    
    private String type;
    private String clockSpeed;
    private int numberOfModules;
    private int sizeOfModules;
    private int totalSize;
    
    /**
     * Insert all data of ram into ArrayLists
     * @param cod the code of ram component
     * @param brand the brand of ram component
     * @param model the model of ram component
     * @param type the type of ram component
     * @param clockSpeed the speed of ram component
     * @param tdp the consumptionpower of ram component
     * @param numberOfModules the number of modular of ram component
     * @param sizeOfModules the size of modular of ram component
     * @param totalSize the size of ram component
     * @param price the price of ram component
     */
    public RAM(int cod, String brand, String model, String type, String clockSpeed, int tdp, int numberOfModules, int sizeOfModules, Double price)
    {
        super(cod, brand, model, tdp, price);
        this.type = type;
        this.clockSpeed = clockSpeed;
        this.numberOfModules = numberOfModules;
        this.sizeOfModules = sizeOfModules;
        this.totalSize = this.numberOfModules*this.sizeOfModules;
    }
    
     /**
     * Get all types of ram table
     * @return all tupes of ram components
     */
    public String getType()
    {
        return type;
    }

    /**
     * Get all speeds of ram table
     * @return all speeds of ram components
     */
    public String getClockSpeed()
    {
        return clockSpeed;
    }

    /**
     * Get all NOMs of ram table
     * @return all NOMs of ram components
     */
    public int getNumberOfModules()
    {
        return numberOfModules;
    }

    /**
     * Get all SOMs of ram table 
     * @return all SOMs of ram components
     */
    public int getSizeOfModules() {
        return sizeOfModules;
    }

    /**
     * Get all sizes of ram table
     * @return all size of ram components
     */
    public int getTotalSize()
    {
        return totalSize;
    }
    
    @Override
    public String getComponent()
    {
        return "RAM";
    }

    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "\n");
        sb.append("RAM type = " + type + "\n");
        sb.append("Clock speed = " + clockSpeed + "\n");
        sb.append("Number of modules = " + numberOfModules + "\n");
        sb.append("Size of modules = " + sizeOfModules + "\n");
        sb.append("Total RAM size = " + totalSize + "\n");
        output = sb.toString();
        return output;
    }
}