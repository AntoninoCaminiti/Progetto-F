package JSPElements;
import java.sql.*;
import java.util.ArrayList;
import Components.Component;
import DatabaseElements.DBComponentController;
import Exceptions.ComponentLoadingException;
public class ComponentParser {

    /**
     *
     */
    public ComponentParser()
    {
        
    }
    
    /**
     * Get a string of the brand and model of a component (using the string -CC- in order to split them) given its code 
     * @param cod the code of the corresponding component
     * @return the brand and the model of corresponding component
     * @throws ComponentLoadingException is a component could not be loaded
     * @throws SQLException if an SQL exception is occurred
     */
    public Component getComponent(int cod) throws SQLException,ComponentLoadingException
    {
        Component cmp = null;
        DBComponentController dbc = new DBComponentController();
        ArrayList <Component> tmp = null;
        if(cod>1000 && cod < 2000)  tmp = dbc.loadMB();
        if(cod>2000 && cod < 3000)  tmp = dbc.loadCPU();
        if(cod>3000 && cod < 4000)  tmp = dbc.loadRAM();
        if(cod>4000 && cod < 5000)  tmp = dbc.loadGCard();
        if(cod>5000 && cod < 6000)  tmp = dbc.loadMDrive();
        if(cod>6000 && cod < 7000)  tmp = dbc.loadPS();
        if(cod>7000 && cod < 8000)  tmp = dbc.loadCase();
        for(int i = 0; i < tmp.size(); i++)
        {
            if(tmp.get(i).getCod() == cod)
            cmp = tmp.get(i);
        }
        return cmp;
    }
    
}