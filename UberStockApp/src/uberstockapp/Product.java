package uberstockapp;

import interfaces.SQL_Interface;
import java.sql.ResultSet;
import uberstockapp.database.sqlController;

/**
 *
 * @author tri.le
 */
public class Product implements SQL_Interface{
    private int productID;
    private final String name;
    private final int category;
    private final float price;
    private int quantity;
    private String imageURI;
    
    sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
    
    public int getProductID(){
        return this.productID;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }
            
    public String getName(){
        return this.name;
    }
    
    public int getCategory(){
        return this.category;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public boolean enoughStock(int quantity)
    {
        if(this.quantity >= quantity)
        {
            
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void reduceQuantity(int quantity)
    {
        this.quantity -= quantity;
    }
    
    public void increaseQuantity(int quantity)
    {
        this.quantity += quantity;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public float getPrice(){
        return this.price;
    }
    
    public boolean isAvailable(){
        return getQuantity() != 0;
    }
    
    public String getImageURI()
    {
        return this.imageURI;
    }
    
    public void setImageURI(String imageURI)
    {
        this.imageURI = imageURI;
    }
    
    public Product(int ProductID, String name, int category, float price, int quantity, String imageURI){
        this.productID = ProductID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.imageURI = imageURI;
    }

    @Override
    public void executeSQL(String commandType) {
        String sqlUpdateCommand;
        if(commandType == "Update")
        {
            sqlUpdateCommand= "Update InventoryItems SET ItemStock = " + getQuantity() + " where ItemID = "+ getProductID();
            sql.executeUpdate(sqlUpdateCommand);
        }
    }

    @Override
    public void setResults(ResultSet results) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
