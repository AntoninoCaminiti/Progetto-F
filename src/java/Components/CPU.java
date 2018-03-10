package Components;
import DatabaseElements.DBConnection;
import DatabaseElements.DatabaseInit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class take all data of cpu from database and insert they in ArrayLists
 * @author Utente
 */
public class CPU extends Component {
    
    private String socket;
    private Double clockSpeed;
    private int core;
    
    /**
     * @param cod the code of cpu component
     * @param brand the brand of cpu component
     * @param model the model of cpu component
     * @param socket the socket of cpu component
     * @param frequency the frequency of cpu component
     * @param core the cores of cpu component
     * @param tdp the consumption power of cpu component
     * @param price the price of cpu component
     */
    public CPU(int cod, String brand, String model, String socket, Double frequency, int core, int tdp, Double price)
    {
        super(cod, brand, model, tdp, price);
        this.socket = socket;
        this.clockSpeed = frequency;
        this.core = core;
    }
    
    /**
     * Take all sockets of cpu table
     * @return all sockets of cpu components
     */
    public String getSocket()
    {
        return socket;
    }
    
    /**
     * Take all frequencies of cpu table
     * @return all clock frequencies of cpu components
     */
    public Double getClockSpeed()
    {
        return clockSpeed;
    }

    /**
     * Take all cores of cpu table
     * @return all cores of cpu components
     */
    public int getCore()
    {
        return core;
    }

    /**
     * @return the type of component that is equal to its mysql table name
     */
    @Override
    public String getComponent()
    {
        return "CPU";
    }
    
    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "\n");
        sb.append("Socket = " + socket +"\n");
        sb.append("Clock speed = " + clockSpeed +"\n");
        sb.append("Core = " + core);
        output = sb.toString();
        return output;
    }
    
}