//package src;


/**
 * Write a description of class BuildOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 


import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
public class BuildOrder
{
    
        public static void main(String[] args) {
        // TODO Auto-generated method stub

        ClientResource resource = new ClientResource("http://aws.nguyenresearch.com:8080/cart");
        
        Representation result = resource.get();
        
        try {
            JSONObject json = new JSONObject(result.getText());
            String id = (String) json.get("id");
            System.out.println(id);
            
            
            JSONArray array = json.getJSONArray("items");
            
            ProductDecoratorInterface pdi = new Item(); 
            ProductDecoratorInterface pdi1 = new Book(pdi);
            ProductDecoratorInterface pdi2 = new MusicCD(pdi1) ;
            ProductDecoratorInterface pdi3 = new ChocolateBar(pdi2) ;
            
            ProductDecoratorInterface pdi4 = new ImportedPerfumeBottle(pdi3);
            ProductDecoratorInterface pdi5 = new PerfumeBottle(pdi4);
            ProductDecoratorInterface pdi6 = new HeadachePill(pdi5);
            ProductDecoratorInterface pdi7 = new BoxOfImportedChocolate(pdi6);
            
                            
            for (int i = 0; i < array.length(); i++) {

                JSONObject obj = array.getJSONObject(i);
                System.out.println(obj);
                
                if (obj.get("description").toString().toLowerCase().contains("book")) 
                {

                    pdi1.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price"), pdi);
                }
                
                if (obj.get("description").toString().toLowerCase().contains("music")) {

                    pdi2.set(obj.get("description").toString(),
                            (int) obj.get("qty"), (double) obj.get("price") , pdi1);
                }  
                
                if (obj.get("description").toString().toLowerCase().contains("bar")) 
                {

                    pdi3.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price") , pdi2);
                }
                                 
                if (obj.get("description").toString().toLowerCase().contains("imported perfume")) 
                {

                    pdi4.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price") , pdi3);
                }
                
                if (obj.get("description").toString().toLowerCase().contains("bottle of perfume")) 
                {

                    pdi5.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price") , pdi4);
                }
                
                if (obj.get("description").toString().toLowerCase().contains("pill")) 
                {

                    pdi6.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price") , pdi5);
                }
                
                if (obj.get("description").toString().toLowerCase().contains("box of imported")) 
                {
                    pdi7.set(obj.get("description").toString(), (int) obj.get("qty"),
                            (double) obj.get("price") , pdi6);
                }              
                
            }
            System.out.println("----------------");
            pdi7.printDescription();
            System.out.println("Total: "+ pdi7.calculateTotalPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.println("Sales Taxes: "+ pdi7.calculateTax().setScale(2, BigDecimal.ROUND_HALF_UP));
            
        } catch (

        ResourceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
}