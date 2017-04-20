import java.math.BigDecimal;

//package src;


/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item implements ProductDecoratorInterface
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // Initialize instance variables
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    //public static final BigDecimal roundTwoDecimal =  BigDecimal(100.0);
    //public static final BigDecimal roundSalesTax =  0.05;
    
    public static final BigDecimal salesTaxRate = new BigDecimal("0.10").setScale(2, BigDecimal.ROUND_UP); 
    public static final BigDecimal importTaxRate = new BigDecimal("0.05").setScale(2, BigDecimal.ROUND_UP); 
    		
    
    public BigDecimal calculateItemPrice() // to calc base price + tax on the individual item
     {return new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_UP);}        
    
    public BigDecimal calculateTotalPrice()
    {return new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_UP);}
    
    public BigDecimal calculateTax() // to calculate tax 
     {return new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_UP);}
        
    public void printDescription() // to print item description
    {}
    
    public void set(String description, int qty, double price, ProductDecoratorInterface pdi)
    {}
    
    public BigDecimal roundTwoDecimal(BigDecimal input)
    {
    	return input;
    	//return (Math.round(input * roundTwoDecimal) / roundTwoDecimal);
    }
    public BigDecimal getSalesTax(BigDecimal input)
    {	
    	input = input.multiply(salesTaxRate).setScale(2, BigDecimal.ROUND_UP);
    	BigDecimal twenty = new BigDecimal("20");
    	BigDecimal salesTax = new BigDecimal("0.00");
    	salesTax = salesTax.multiply(twenty.multiply(input)).setScale(2, BigDecimal.ROUND_UP);
    	salesTax = salesTax.divide(twenty, 2, BigDecimal.ROUND_UP);
    	return input;
    	//return ( (BigDecimal) (long) (input * 20 + 0.5) ) / 20;
    	//return (BigDecimal)(Math.round(input * 20) / 20.0);
    }
    
 }


