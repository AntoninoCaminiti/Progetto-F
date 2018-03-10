package Components;
import java.util.ArrayList;

/**
 * This class take all data of motherboard from database and insert they in ArrayLists
 * @author Utente
 */
public class Motherboard extends Component {
    
    private String socket;
    private String formfactor;
    private String chipset;
    private int ramSlot;
    private String ramType;
    private int maxRamSupported;
    
    /**
     * Insert all data of motherboard into ArrayLists
     * @param cod the code of motherboard component
     * @param brand the brand of motherboard component
     * @param model the model of motherboard component
     * @param socket the socket of motherboard component
     * @param formfactor the formfactor of motherboard component
     * @param chipset the chipset of motherboard component
     * @param ramSlot the number of ram supported
     * @param ramType the type of ram supported
     * @param maxRamSupported the max size of ram supported
     * @param tdp the consumption power of motherboard component
     * @param price the price of motherboard component
     */
    
    public Motherboard(int cod, String brand, String model, String socket, String formfactor, String chipset, int ramSlot, String ramType, int maxRamSupported, int tdp, Double price)
    {
        super(cod, brand, model, tdp, price);
        this.socket = socket;
        this.formfactor = formfactor;
        this.chipset = chipset;
        this.ramSlot = ramSlot;
        this.ramType = ramType;
        this.maxRamSupported = maxRamSupported;
    }

     /**
     * Get all chipsets of motherboard table
     * @return all chipsets of motherboard components
     */
    public String getChipset()
    {
        return chipset;
    }

    /**
     * Get all sockets of motherboard table
     * @return all sockets of motherboard components
     */
    public String getSocket()
    {
        return socket;
    }

    /**
     * Get all formfactors of motherboard table
     * @return all formfactors of motherboard components
     */
    public String getFormfactor()
    {
        return formfactor;
    }

    /**
     * Get all ramslots of motherboard table
     * @return all ramslots of motherboard components
     */
    public int getRamSlot()
    {
        return ramSlot;
    }

    /**
     * Get all maxrams of motherboard table
     * @return all maxrams of motherboard components
     */
    public int getMaxRamSupported()
    {
        return maxRamSupported;
    }

    /**
     * Get all ramtypes of motherboard table
     * @return all ramtype of motherboard components
     */
    public String getRamType()
    {
        return ramType;
    }

    @Override
    public String getComponent()
    {
        return "MOTHERBOARD";
    }
    
    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Socket = " + socket + "\n");
        sb.append("FormFactor = " + formfactor + "\n");
        sb.append("Chipset = " + chipset + "\n");
        sb.append("RAM slots = " + ramSlot + "\n");
        sb.append("RAM type = " + ramType + "\n");
        sb.append("Max RAM supported = " + maxRamSupported);
        output = sb.toString();
        return output;
    }

    

}