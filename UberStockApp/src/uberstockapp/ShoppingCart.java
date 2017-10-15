/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.util.ArrayList;

/**
 *
 * @author Kyle
 */
public class ShoppingCart {
    
    private ArrayList<Product> cartList;
    private Product previewProduct = null;
    
    public ShoppingCart()
    {
        cartList = new ArrayList<>();
    }
    
    public void setPreviewProduct(Product product)
    {
        this.previewProduct = product;
    }
    
    public boolean addCartItem(int quantity)
    {
        //Case where product has more than enough in stock to add to cart. Returns true.
        if(previewProduct.reduceQuantity(quantity))
        {      
            cartList.add(previewProduct);
        }
                      
        return false;
    }
    
    
    
}
