/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class ShoppingCart {
    
    private ArrayList<Product> cartList;
    private Product previewProduct = null;
    private HashMap<JPanel, Product> panelDeleteBtnMap;
    
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
            if(previewProduct.reduceQuantity(quantity))
            {      
                //add to list
                cartList.add(previewProduct);

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
        for(Product productTemp : cartList)
        {
            productList += (productTemp.getName() + " ");
        }
        
        return productList;
    }

    public ArrayList<Product> getShoppingCart()
    {
        return this.cartList;
    }  
}
