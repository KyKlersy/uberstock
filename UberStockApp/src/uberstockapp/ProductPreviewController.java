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
 *
 * @author Kyle
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

    public final void setPreviewFrame(JLabel itemImage, JLabel itemName, JLabel itemPrice, JLabel itemStock, JTextField itemQuantity)
    {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.itemQuantity = itemQuantity;
        
    }
    
    public final void setPreviewFrameView(Icon imageIcon, String name, String price, String stock)
    {
        this.itemImage.setIcon(imageIcon);
        this.itemName.setText(name);
        this.itemPrice.setText(price);
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

    @Override
    public void reset() {
        itemImage.setIcon(null);
        itemName.setText("");
        itemPrice.setText("");
        itemStock.setText("");
        itemQuantity.setText("");        
        
    }
        
}
