package uberstockapp;
/**
 *
 * @author tri.le
 */
public class Product {
    private int productID;
    private final String name;
    private final int category;
    private final float price;
    private int quantity;
    private String imageURI;
    
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
}
