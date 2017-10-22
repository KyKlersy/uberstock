/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Interfaces.Resetable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class ShoppingCart implements Resetable{
    
    private final HashMap<Product, Product> cartList;
    private Product previewProduct = null;
    private final HashMap<JPanel, Product> panelDeleteBtnMap;    
    private final HashMap<Product, JLabel> mapPreviewToQuantityLabel;
    
    private final ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    
    public ShoppingCart()
    {
        cartList = new HashMap<>();
        panelDeleteBtnMap = new HashMap<>();
        mapPreviewToQuantityLabel = new HashMap<>();
        
    }
    
    public void setPreviewProduct(Product product)
    {
        this.previewProduct = product;
    }
    
    public boolean addCartItem(int quantity, JPanel cartPanel)
    {
        ProductPreviewController productPreviewController = (ProductPreviewController)serviceLocator.getService("ProductPreviewController");
        //Preview item selected.
        assert (previewProduct != null): "No preview product selected";
        
        /* Confirm the quantity requested is avaliable */
        if(previewProduct.enoughStock(quantity))
        {
            /* Check to make sure the item being added is not already in the cart */
            if(!cartList.containsKey(previewProduct))
            {
                /* Create a deep copy of the original product item values from the database */
                Product deepCopiedProduct = new Product(previewProduct.getProductID(), previewProduct.getName(), previewProduct.getCategory(), previewProduct.getPrice(), previewProduct.getQuantity(), previewProduct.getImageURI());
                
                /* Create item control form */
                JLabel itemNameJLabel = new JLabel(previewProduct.getName());
                JLabel quantityJLabel = new JLabel("Quantity: "+Integer.toString(quantity));
                JLabel priceJLabel = new JLabel("$"+Float.toString(previewProduct.getPrice()));
                JButton deleteItemButton = new JButton(" X ");

                JPanel panelGroup = new JPanel();
                panelGroup.add(itemNameJLabel);
                panelGroup.add(priceJLabel);
                panelGroup.add(quantityJLabel);
                panelGroup.add(deleteItemButton);

                deleteItemButton.addActionListener((ae) -> {
                    Product originalDatabaseProduct = cartList.get(previewProduct);
                    Product modifiedDatabaseProduct = panelDeleteBtnMap.get(panelGroup);
                    
                    assert (originalDatabaseProduct != null): "Error could not get originalDatabaseProduct from map";
                    //System.out.println("originalDatabaseProduct val: " + originalDatabaseProduct.getQuantity());
                    assert (modifiedDatabaseProduct != null): "Error could not get modifiedDatabaseProduct from map";
                    //System.out.println("modifiedDatabaseProduct val: " + modifiedDatabaseProduct.getQuantity());
                    //System.out.println("original db value: " + originalDatabaseProduct.getQuantity() + " Reduced local value: "+modifiedDatabaseProduct.getQuantity());
                    modifiedDatabaseProduct.increaseQuantity((originalDatabaseProduct.getQuantity() - modifiedDatabaseProduct.getQuantity()));
                    
                    productPreviewController.getItemStock().setText(Integer.toString(previewProduct.getQuantity()));
                    productPreviewController.getItemQuantity().setText("");
                    
                    cartList.remove(previewProduct);
                    panelDeleteBtnMap.remove(panelGroup);
                    mapPreviewToQuantityLabel.remove(previewProduct);
                    cartPanel.remove(panelGroup);                                     
                    cartPanel.repaint();
                    cartPanel.revalidate();
                    ///System.out.println(this.toString());
                });
                
                cartList.put(previewProduct,deepCopiedProduct);
                panelDeleteBtnMap.put(panelGroup, previewProduct);
                mapPreviewToQuantityLabel.put(previewProduct, quantityJLabel);
                
                /* reduce the quantity in stock for product */
                previewProduct.reduceQuantity(quantity);
                
                if(previewProduct.getQuantity()== 0)
                {
                    productPreviewController.getItemStock().setText("Not available");
                }
                else
                {
                    productPreviewController.getItemStock().setText(Integer.toString(previewProduct.getQuantity()));
                }
                
                productPreviewController.getItemQuantity().setText("");

                cartPanel.add(panelGroup);
                
                return true;
                
                
            }
            else /* Item is already in the list */
            {
                
                Product cartProduct = cartList.get(previewProduct);
                System.out.println("Cart Product Val: " + cartProduct.getQuantity());
                JLabel quantityJLabel = mapPreviewToQuantityLabel.get(previewProduct);
                previewProduct.reduceQuantity(quantity);
                System.err.println("Stock remaining: " + previewProduct.getQuantity());
                quantityJLabel.setText(Integer.toString((cartProduct.getQuantity() - previewProduct.getQuantity())));
                
                productPreviewController.getItemStock().setText(Integer.toString(previewProduct.getQuantity()));
                productPreviewController.getItemQuantity().setText("");

            }
            
            
            
        }
                      
        return false;
    }
   
    public HashMap<Product,Product> getCartHashMap()
    {
        return this.cartList;   
    }
    
    @Override
    public String toString()
    {
        String productList = "";
        
        //productList = cartList.stream().map((productTemp) -> (productTemp.getName() + " " + productTemp.getQuantity())).reduce(productList, String::concat);
        
        return productList;
    }

    public void clearList()
    {        
        cartList.clear();        
        panelDeleteBtnMap.clear();
        mapPreviewToQuantityLabel.clear();        
    }
    
    @Override
    public void reset() {
        
        for(Map.Entry<Product,Product> cartListEntry : cartList.entrySet())
        {
            
            Product tempModified = cartListEntry.getKey();
            Product tempOriginal = cartListEntry.getValue();
            System.out.println("Modififed val: " + tempModified.getQuantity() + " original val: " + tempOriginal.getQuantity());
            tempModified.setQuantity(tempOriginal.getQuantity());
            
        }

    }
}
