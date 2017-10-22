/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kyle
 */
public class CategoryViewController {
    
    private HashMap<JButton, Category> categoryButtonMap;

    private CategoryManager categoryManager;
    
    private JPanel categoryControlPanel;
    private JPanel productBtnGrid;
    
    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    
    public CategoryViewController(JPanel categoryControlPanel, JPanel productBtnGrid) {
        categoryButtonMap = new HashMap<>();        
        categoryManager = (CategoryManager)serviceLocator.getService("CategoryManager");
        this.categoryControlPanel = categoryControlPanel;
        this.productBtnGrid = productBtnGrid;
    }
    
    public void buildCategoryView()
    {
        int row = 0;
        int col = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.fill = SwingUtilities.HORIZONTAL;
        for(Category category : categoryManager.getCategoryList())
        {
            //System.out.println("Category " + category.getCategoryName());
            JButton button = new JButton();
            button.setText(category.getCategoryName());
            button.setPreferredSize(new Dimension(200, 100));
            //button.setMinimumSize(new Dimension(100, 100));
            button.setMargin(new Insets(5, 5, 5, 5));
            
            
            button.addActionListener((ae) -> {
                Category categoryClicked = categoryButtonMap.get((JButton)ae.getSource());
                System.err.println("Category Clicked: " + categoryClicked.getCategoryID());

                ProductViewController productViewController = (ProductViewController)serviceLocator.getService("ProductViewController");
                productViewController.buildViewPanel(categoryClicked.getCategoryID(), this.productBtnGrid);

            });
            
            
            categoryButtonMap.put(button, category);
            
            gridBagConstraints.gridx = row;
            gridBagConstraints.gridy = col;
            
            categoryControlPanel.add(button, gridBagConstraints);
            categoryControlPanel.repaint();
            ++col;
        }
        
    }    
}
