import java.math.BigDecimal;

//package src;


/**
 * Write a description of class PerfumeBottle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PerfumeBottle extends Item
{
    // instance variables - replace the example below with your own
   String description = null;
   int qty = 0;
   
   BigDecimal itemPrice = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_UP);
   BigDecimal itemBasicTax = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_UP);
   ProductDecoratorInterface pdi;

    /**
     * Constructor for objects of class PerfumeBottle
     */
    public PerfumeBottle(ProductDecoratorInterface pdi)
    {
        this.pdi = pdi;
    }
    
    public  void set (String description, int qty, double price, ProductDecoratorInterface pdi)
    {
        // initialise instance variables
       this.description = description;
       this.qty = qty;
       this.itemPrice = new BigDecimal(price);
       this.pdi = pdi;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void printDescription() 
    {
    	if(this.description != null)
    		System.out.println(description + ": " + calculateItemPrice().setScale(2, BigDecimal.ROUND_HALF_UP)); 
    	pdi.printDescription();
             
    }
    
     public BigDecimal calculateItemPrice()
    {
    	 BigDecimal q = new BigDecimal(String.valueOf(qty));
    	 itemPrice = itemPrice.multiply(q);
         
         
         itemBasicTax = getSalesTax(itemPrice);
    	 return (itemPrice.add(itemBasicTax));              
    }
    
    public BigDecimal calculateTotalPrice()
    {
    	BigDecimal sum = new BigDecimal("0.00");
        sum = sum.add(itemPrice);
        sum = sum.add(itemBasicTax);
        sum = sum.add(pdi.calculateTotalPrice());
    	return sum;
    }
    
    public BigDecimal calculateTax()
    {
    	return ( itemBasicTax.add(pdi.calculateTax()));  
    }
}
