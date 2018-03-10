/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

/**
 *
 * @author root
 */
public abstract class Component {
    
    private int cod;
    private String brand;
    private String model;
    private int tdp;
    private Double price;
    
    public Component(int cod, String brand, String model, int tdp, Double price) {
        this.cod = cod;
        this.brand = brand;
        this.model = model;
        this.tdp = tdp;
        this.price = price;
    }

    /**
     * Take all codes of cpu table
     * @return all codes of cpu components
     */
    public int getCod() {
        return cod;
    }

    /**
     * Take all brands of cpu table
     * @return all brands of cpu components
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Take al models of cpu table
     * @return all models of cpu components
     */
    public String getModel() {
        return model;
    }

    /**
     * Take all tdps of cpu table
     * @return all tdps of cpu components
     */
    public int getTdp() {
        return tdp;
    }
    
    /**
     * Take all prices of cpu table
     * @return all prices of cpu components
     */
    public Double getPrice() {
        return price;
    }
    
    /**
     * @return the type of component you have as an object
     */
    public abstract String getComponent();

    @Override
    public String toString() {
        String output;
        StringBuilder sb = new StringBuilder();
        sb.append("Code = " + cod + "\n");
        sb.append("Brand = " + brand + "\n");
        sb.append("Model = " + model + "\n");
        sb.append("TDP = " + tdp + "\n");
        sb.append("Price = " + price);
        output = sb.toString();
        return output;
    }
    
    
    
}
