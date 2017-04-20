import java.math.BigDecimal;

//package src;


/**
 * Write a description of interface ProductDecoratorInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ProductDecoratorInterface
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    public abstract BigDecimal calculateItemPrice(); // to calc base price + tax on the individual item
    
    public abstract BigDecimal calculateTotalPrice();
    
    public abstract BigDecimal calculateTax(); // to calculate tax 
        
    public abstract void printDescription(); // to print item description
    
    public abstract void set(String description, int qty, double price, ProductDecoratorInterface pdi);
    
}
