/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Interfaces.Resetable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class ShoppingCart implements Resetable{
    
    private final ArrayList<Product> cartList;
    private Product previewProduct = null;
    private final HashMap<JPanel, Product> panelDeleteBtnMap;
    
    private final ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    
    public ShoppingCart()
    {
        cartList = new ArrayList<>();
        panelDeleteBtnMap = new HashMap<>();
        
    }
    
    public void setPreviewProduct(Product product)
    {
        this.previewProduct = product;
    }
    
    public boolean addCartItem(int quantity, JPanel cartPanel)
    {
        //Preview item selected.
        if(previewProduct != null)
        {
            //Case where product has more than enough in stock to add to cart. Returns true.
            if(previewProduct.enoughStock(quantity))
            {      
                //add to list
                
                Product deepCopy = new Product(previewProduct.getProductID(), previewProduct.getName(), previewProduct.getCategory(), previewProduct.getPrice(), previewProduct.getQuantity(), previewProduct.getImageURI());
                cartList.add(deepCopy);
                
                previewProduct.reduceQuantity(quantity);
                System.err.println(deepCopy.getQuantity());
                JLabel itemNameJLabel = new JLabel(previewProduct.getName());
                JLabel quantityJLabel = new JLabel("Quantity: "+Integer.toString(quantity));
                JLabel priceJLabel = new JLabel("$"+Float.toString(previewProduct.getPrice()));
                JButton deleteItemButton = new JButton(" X ");

                JPanel panelGroup = new JPanel();
                panelGroup.add(itemNameJLabel);
                panelGroup.add(priceJLabel);
                panelGroup.add(quantityJLabel);
                panelGroup.add(deleteItemButton);

                panelDeleteBtnMap.put(panelGroup, previewProduct);


                deleteItemButton.addActionListener((ae) -> {
                    cartList.remove(panelDeleteBtnMap.get(panelGroup));
                    cartPanel.remove(panelGroup);
                    cartPanel.repaint();
                    cartPanel.revalidate();
                    System.out.println(this.toString());
                });

                ProductPreviewController productPreviewController = (ProductPreviewController)serviceLocator.getService("ProductPreviewController");
                
                productPreviewController.getItemStock().setText(Integer.toString(previewProduct.getQuantity()));
                productPreviewController.getItemQuantity().setText("");
                
                
                cartPanel.add(panelGroup);
                
                return true;
            }
        }

                      
        return false;
    }
   
    @Override
    public String toString()
    {
        String productList = "";
        
        productList = cartList.stream().map((productTemp) -> (productTemp.getName() + " " + productTemp.getQuantity())).reduce(productList, String::concat);
        
        return productList;
    }

    public ArrayList<Product> getShoppingCart()
    {
        return this.cartList;
    }  

    @Override
    public void reset() {
        ProductManager productManager = (ProductManager) serviceLocator.getService("ProductManager");
        
        /* Loop through this cart list adding back the quantity to the original product list */
        cartList.forEach((cartproduct) -> {
            System.out.println("Deep Copy Original count " + cartproduct.getQuantity());   
            productManager.getProductList().forEach((product) -> {  
                if(cartproduct.getName() == product.getName())
                {    
                    System.out.println("Changed Internal count " + product.getQuantity());
                    product.setQuantity(cartproduct.getQuantity());  
                }                
            });
        });
        
        panelDeleteBtnMap.clear();
    }
}
