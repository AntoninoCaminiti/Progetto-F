package Components;

/**
 * This class take all data of powersupply from database and insert they in ArrayLists
 * @author Utente
 */
public class PowerSupply extends Component {
    
    private String serie;
    private String form;
    private String efficiency;
    private int maxTDPSupported;
    private String modular;
    
    /**
     * Insert all data of powersupply into ArrayLists
     * @param cod the code of PS component
     * @param brand the brand of PS component
     * @param model the model of PS component
     * @param serie the series of PS component
     * @param form the form of PS component
     * @param efficiency the efficiency of PS component
     * @param maxTDPSupported the max consumption of power supported
     * @param modular the modular of PS component
     * @param price the price of PS component
     */
    public PowerSupply(int cod, String brand, String model, String serie, String form, String efficiency, int maxTDPSupported, String modular, Double price)
    {
        super(cod, brand, model, 0, price);
        this.serie = serie;
        this.form = form;
        this.efficiency = efficiency;
        this.maxTDPSupported = maxTDPSupported;
        this.modular = modular;
    }

     /**
     * Get all series of PS table
     * @return all series of PS components
     */
    public String getSerie()
    {
        return serie;
    }

    /**
     * Get all forms of PS components
     * @return all forms of PS components
     */
    public String getForm()
    {
        return form;
    }

    /**
     * Get all efficiencies of PS table
     * @return all efficiencies of PS components
     */
    public String getEfficiency()
    {
        return efficiency;
    }

    /**
     * Get all Maxtdps of PS table
     * @return all Maxtdps of PS components
     */
    public int getMaxTDPSupported()
    {
        return maxTDPSupported;
    }

    /**
     * Get all modulars of PS table
     * @return all modulars of PS components
     */
    public String getModular()
    {
        return modular;
    }
    
    @Override
    public String getComponent()
    {
        return "POWER_SUPPLY";
    }

    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Serie = " + serie + "\n");
        sb.append("Form = " + form + "\n");
        sb.append("Efficiency = " + efficiency + "\n");
        sb.append("Max TDP supported = " + maxTDPSupported + "\n");
        sb.append("Modular = " + modular + "\n");
        output = sb.toString();
        return output;
    }

    
    
}