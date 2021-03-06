/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Interfaces.Resetable;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Handle the product information GUI 
 * when user select specific product
 * @author Kyle and Tri
 */
public class ProductPreviewController implements Resetable{

    private JLabel itemImage;
    private JLabel itemName;
    private JLabel itemPrice;
    private JLabel itemStock;
    private JTextField itemQuantity;
    
    public ProductPreviewController(JLabel itemImage, JLabel itemName, JLabel itemPrice, JLabel itemStock, JTextField itemQuantity) 
    {
        setPreviewFrame(itemImage, itemName, itemPrice, itemStock, itemQuantity);
    }
    
    /**
     * Constructor set up all members
     * @param itemImage
     * @param itemName
     * @param itemPrice
     * @param itemStock
     * @param itemQuantity 
     */
    public final void setPreviewFrame(JLabel itemImage, JLabel itemName, JLabel itemPrice, JLabel itemStock, JTextField itemQuantity)
    {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemQuantity = itemQuantity;
        
    }
    /**
     * update when user select product
     * @param imageIcon
     * @param name
     * @param price
     * @param stock 
     */
    public final void setPreviewFrameView(Icon imageIcon, String name, String price, String stock)
    {
        this.itemImage.setIcon(imageIcon);
        this.itemName.setText(name);
        this.itemPrice.setText(price);
        
        if (Integer.parseInt(stock) == 0)
            this.itemStock.setText("Not Available");
        else
            this.itemStock.setText(stock);
        
    }
    
    
    public JLabel getItemImage() {
        return itemImage;
    }

    public void setItemImage(JLabel itemImage) {
        this.itemImage = itemImage;
    }

    public JLabel getItemName() {
        return itemName;
    }

    public void setItemName(JLabel itemName) {
        this.itemName = itemName;
    }

    public JLabel getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(JLabel itemPrice) {
        this.itemPrice = itemPrice;
    }

    public JLabel getItemStock() {
        return itemStock;
    }

    public void setItemStock(JLabel itemStock) {
        this.itemStock = itemStock;
    }

    public JTextField getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(JTextField itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    /**
     * another interface for me to use this form control
     */
    @Override
    public void reset() {
        itemImage.setIcon(null);
        itemName.setText("");
        itemPrice.setText("");
        itemStock.setText("");
        itemQuantity.setText("");        
        
    }
        
}
