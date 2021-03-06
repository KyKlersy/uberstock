/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * Handle the product GUI and features in the stock
 * @author Kyle and Tri
 */
public class ProductViewController {

    private final HashMap<Integer, JPanel> categoryPanelViewMap;
    private final HashMap<JButton, Product> productButtonMap;
    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    public ProductViewController() 
    {
        categoryPanelViewMap = new HashMap<>();
        productButtonMap = new HashMap<>();
    }
    
    /**
     * Create product categories and books for each category
     * @param categoryID
     * @param btnPanel 
     */
    public final void buildViewPanel(int categoryID, JPanel btnPanel)
    {
        ProductManager productManager = (ProductManager)serviceLocator.getService("ProductManager");
        
        ArrayList<Product> categoryMatchedProduct = new ArrayList<>();
        btnPanel.removeAll();
        
        productManager.getProductList().stream().filter((product) -> (product.getCategory() == categoryID)).forEachOrdered((product) -> {
            categoryMatchedProduct.add(product);
        });
        
        
        String imageURI = "../resources/imgs/";
        int row = 0;
        int col = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5); 
        
        //build category GUI
        for(Product product : categoryMatchedProduct)
        {
            
            String resourcePath = imageURI + product.getImageURI();
            //System.err.println("Product: " + product.getName());
            ImageIcon productImage = new ImageIcon(new ImageIcon(getClass().getResource(resourcePath)).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

            JButton button = new JButton();  //, productImage);

            button.setPreferredSize(new Dimension(350,350));
            button.setText(product.getName());
            button.setIcon(productImage);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setMinimumSize(new Dimension(250, 250));
            button.setPreferredSize(new Dimension(250, 250));
            button.setMargin(new Insets(5, 5, 5, 5));

            //Start build books for category button clicked
            button.addActionListener((ae) -> {
                ShoppingCart shoppingCart = (ShoppingCart)serviceLocator.getService("ShoppingCart");
                ProductPreviewController productPreviewController = (ProductPreviewController)serviceLocator.getService("ProductPreviewController");
                Product clickedProduct = productButtonMap.get((JButton)ae.getSource());
                ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource(imageURI + clickedProduct.getImageURI())).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
                
                productPreviewController.setPreviewFrameView(icon,
                        clickedProduct.getName(), ("$"+Float.toString(clickedProduct.getPrice())),Integer.toString(clickedProduct.getQuantity()));

                shoppingCart.setPreviewProduct(clickedProduct);

            });

            productButtonMap.put(button, product);

            gridBagConstraints.gridx = row;
            gridBagConstraints.gridy = col;

            //System.err.println("Column: " + col + " Row: " + row);
            btnPanel.add(button, gridBagConstraints);
            btnPanel.repaint();
            btnPanel.revalidate();
            ++col;

            if(col % 3 == 0)
            {
                //System.err.println("Col Mod 3 true: " + col);
                col = 0;
                ++row;
            }

            //System.out.println(product.getImageURI());
        }
     
    }
       

    public JPanel setView(int category)
    {
       return categoryPanelViewMap.get(category);
    }
    
    
}
