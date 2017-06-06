package VirtualPCConfigurator;


public class Calculator {
    
    //Variable declaration:
    private double dblSubTotal;
    private final double SHIPPING_CHARGE;
    private final double SALES_TAX;
    private double dblShippingChargeTOTAL;
    private double dblSalesTaxTOTAL;

    //Constructor:
    public Calculator() {
        this.dblSubTotal = 0.0;
        this.SHIPPING_CHARGE = 0.025;
        this.SALES_TAX = 0.078;
        this.dblShippingChargeTOTAL = 0.0;
        this.dblSalesTaxTOTAL = 0.0;
    }

    //Accessors:
    public double GetSubTotal() {
        return dblSubTotal;
    }

    public double GetShippingCharge() {
        return SHIPPING_CHARGE;
    }

    public double GetShippingChargeTOTAL() {
        return dblShippingChargeTOTAL;
    }

    public double GetSalesTax() {
        return SALES_TAX;
    }

    public double GetSalesTaxTOTAL() {
        return dblSalesTaxTOTAL;
    }

    //Adds each item to subtotal:
    public void AddToSubTotal(double dblPrice) {
        
        //Adds up subtotal
        dblSubTotal += dblPrice;
    }

    //Clears the calculator:
    public void ClearCalc() {
        
        dblSubTotal = 0.0;
    }

    //Used to subtract an amount from subtotal:
    public void SubtractFromSubTotal(double dblSubtractThis) {
        
        dblSubTotal = dblSubTotal - dblSubtractThis;
    }

    //Gets TOTAL:
    public double GetTOTAL() {
        
        double dblTOTAL;

        dblSalesTaxTOTAL = dblSubTotal * SALES_TAX;

        dblTOTAL = dblSubTotal + dblSalesTaxTOTAL;

        dblShippingChargeTOTAL = dblTOTAL * SHIPPING_CHARGE;

        dblTOTAL += dblShippingChargeTOTAL;

        return dblTOTAL;
    }
}
