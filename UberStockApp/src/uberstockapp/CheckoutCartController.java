/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Interfaces.Resetable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import uberstockapp.database.sqlController;

/**
 *
 * @author Kyle and Tri
 */
public class CheckoutCartController implements Resetable{

    private final float TaxRate = .0825f;
    private final float UClubRewardRate = .05f;
    private final JScrollPane checkoutJPanel;
    private final JPanel checkoutListPanel;
    private final JToggleButton becomeMember;
    private final JPanel membershipPanel;
    private JPanel uclubRewardPanel;
    private JPanel finalTotalPanel;
    private JPanel taxJPanel;
    private JPanel subtotalJPanel;

    private final JTextField firstnameField;
    private final JTextField middleinitalField;
    private final JTextField lastnameField;
    private final JTextField emailField;
    
    
    private JPanel memberFeePanel;
    private float subtotal;
    private float tax;
    private float uclubreward;

    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    ShoppingCart shoppingCart =(ShoppingCart)serviceLocator.getService("ShoppingCart");
    sqlController sql = (sqlController)serviceLocator.getService("sqlController");
    
    private UserAbstractBase user;
    
    public CheckoutCartController(JScrollPane checkoutJPanel, JPanel checkoutListPanel, JToggleButton becomeMember, JPanel membershipPanel, 
                                        JTextField firstnameField, JTextField middleinitalField, JTextField lastnameField, JTextField emailField) {
        
        this.checkoutJPanel = checkoutJPanel;
        this.checkoutListPanel = checkoutListPanel;
        this.becomeMember = becomeMember;
        this.membershipPanel = membershipPanel;
        this.firstnameField = firstnameField;
        this.middleinitalField = middleinitalField;
        this.lastnameField = lastnameField;
        this.emailField = emailField;

    }
    
    
    public void buildCheckOutList()
    {
        checkoutListPanel.removeAll();
        subtotal = 0;
        LayoutManager lm = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        user = (UserAbstractBase)serviceLocator.getService("User");
        
        shoppingCart.getCartHashMap().entrySet().forEach((product) -> {
            int quantityInCart = (product.getValue().getQuantity() - product.getKey().getQuantity());
            
            System.out.println("Product Name: " + product.getKey().getName());
            System.out.println("Quantity in list: "+(product.getValue().getQuantity() - product.getKey().getQuantity())); 
            if( quantityInCart > 1)
            {
                //multiple of the same items
                for(int i = 1; i<= quantityInCart; i++)
                {
                    System.out.println("Count duplicates: " + i);
                    JPanel productJPanel = new JPanel(lm);

                    JLabel productNameLabel = new JLabel(product.getKey().getName());
                    JLabel productPrice = new JLabel("$"+Float.toString(product.getKey().getPrice()));
                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    productJPanel.add(productNameLabel, gbc);
                    gbc.gridx = 2;
                    gbc.gridy = 0;
                    productJPanel.add(productPrice, gbc);   
                    checkoutListPanel.add(productJPanel);
                    
                    addSubtotal(product.getKey().getPrice());
                    
                }
            }
            else
            {
                JPanel productJPanel = new JPanel(lm);

                JLabel productNameLabel = new JLabel(product.getKey().getName());
                JLabel productPrice = new JLabel("$"+Float.toString(product.getKey().getPrice()));
                gbc.gridx = 1;
                gbc.gridy = 0;
                productJPanel.add(productNameLabel, gbc);
                gbc.gridx = 2;
                gbc.gridy = 0;
                productJPanel.add(productPrice, gbc);  
                checkoutListPanel.add(productJPanel);
                checkoutListPanel.repaint();
                checkoutListPanel.revalidate();
                
                addSubtotal(product.getKey().getPrice());
                
            }
            
            
            addToHistory(product.getKey(), user, quantityInCart);
            
            
        });



        calculateUClubReward();
        
        calculateTax();
        
        

        /* Add Subtotal node*/
        buildSubtotalPanel();
        
        /* Add Tax Node */
        buildTaxPanel();
        
        /* Add Final total Node */
        buildFinalTotalPanel();
        
        
        
        if("UberStock Club Member".equals(user.getMembershipName()))
        {
            membershipPanel.setVisible(false);
            buildUClubRewardPanel();

        }
        else
        {
            membershipPanel.setVisible(true);

        }
        
        checkoutJPanel.repaint();
    }
    
    private void addSubtotal(float productPrice)
    {
        this.subtotal += productPrice;
    }
    
    private void removeSubtotal(float removalPrice)
    {
        this.subtotal -= removalPrice;
    }
    
    private void calculateTax()
    {
        this.tax = (this.subtotal * TaxRate);
    }
    
    private void calculateUClubReward()
    {
        this.uclubreward = (this.subtotal * UClubRewardRate);
        
    }
    
    private void addToHistory(Product product, UserAbstractBase user, int quantityInCart)
    {
        String insertProductHistory;
        insertProductHistory = "INSERT INTO PurchaseHistory(PurchaseNumber, PurchaseUserID, ItemID, ItemAmount) VALUES"
                + " (NULL,"+user.getUuid()+","+product.getProductID()+","+ quantityInCart+")";
        
        //System.out.println(product.getProductID() + user.getUuid() + quantityInCart);
        
        sql.executeUpdate(insertProductHistory);
        
        
        
    }
    
    private void buildUClubRewardPanel()
    {
        calculateUClubReward();
        uclubRewardPanel = new JPanel();
        JLabel uClubReward = new JLabel("UClub Rewards ");
        java.text.DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        JLabel uclubRewardAmountLabel = new JLabel("$" + df.format(uclubreward));
        uclubRewardPanel.add(uClubReward);
        uclubRewardPanel.add(uclubRewardAmountLabel);
        checkoutListPanel.add(uclubRewardPanel);
    }
    
    private void buildJoinMembershipPanel()
    {
        memberFeePanel = new JPanel();
        JLabel memberFeeLabel = new JLabel("Join U Club Membership ");
        JLabel memberFeePriceLabel = new JLabel("$19.95");
        memberFeePanel.add(memberFeeLabel);
        memberFeePanel.add(memberFeePriceLabel);
        checkoutListPanel.add(memberFeePanel);
    }
    
    private void buildSubtotalPanel()
    {
        LayoutManager lm = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        subtotalJPanel = new JPanel(lm);

        JLabel subtotalNameLabel = new JLabel("Subtotal: ");
        java.text.DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        JLabel subtotalLabel = new JLabel("$"+df.format(subtotal));
        gbc.gridx = 1;
        gbc.gridy = 0;
        subtotalJPanel.add(subtotalNameLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        subtotalJPanel.add(subtotalLabel, gbc);   
        checkoutListPanel.add(subtotalJPanel);
    }
    
    
    private void buildTaxPanel()
    {
        LayoutManager lm = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        taxJPanel = new JPanel(lm);

        JLabel taxNameLabel = new JLabel("Tax");
        java.text.DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        JLabel taxLabel = new JLabel("$"+df.format(tax));
        gbc.gridx = 1;
        gbc.gridy = 0;
        taxJPanel.add(taxNameLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        taxJPanel.add(taxLabel, gbc);   
        checkoutListPanel.add(taxJPanel);
    }
    
    private void buildFinalTotalPanel()
    {
        /* Final total node */
        LayoutManager lm = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        finalTotalPanel = new JPanel(lm);

        JLabel totalNameLabel = new JLabel("Final Total: ");
        java.text.DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);        
        JLabel finalTotalLabel = new JLabel("$"+df.format(finalTotal()));
        gbc.gridx = 1;
        gbc.gridy = 0;
        finalTotalPanel.add(totalNameLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        finalTotalPanel.add(finalTotalLabel, gbc);   
        checkoutListPanel.add(finalTotalPanel);
    }
    
    public float finalTotal()
    {
        return (this.subtotal + this.tax);
    }
    
    public void checkOutOrder()
    {
        //sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
        
        if(becomeMember.isSelected())
        {
            user.setMembership(2);
        }
        
        if("UberStock Club Member".equals(user.getMembershipName()))
        {
            user.updateUser();
           
            String uclubRewardsUpdate = ("UPDATE USERS SET UclubReward = " + uclubreward + "WHERE UserID = " + user.getUuid());
            sql.executeUpdate(uclubRewardsUpdate);
           
        }
        String testForPaypalUserQuery = "SELECT * FROM PAYPAL WHERE PAYPALUSERID = " + user.getUuid();
        ResultSet resultSet = sql.executeQuery(testForPaypalUserQuery);
        try 
        {
            String command;
            if(!resultSet.isBeforeFirst())
            {
                command = "INSERT INTO PAYPAL(PayPalID,PayPalUserID,FirstName,MiddleInitial,LastName,EmailAddress) VALUES (NULL, "+ user.getUuid()+" ,'"+ firstnameField.getText()
                        +"', '" + middleinitalField.getText() + "', '" + lastnameField.getText() + "', '" + emailField.getText() + "')";
                sql.executeUpdate(command);
            }
            else
            {
                String paypalUpdate = ("UPDATE PAYPAL SET FirstName = '"+ firstnameField.getText() + "', MiddleInitial = '"+ middleinitalField.getText() + "', LastName = '"
                                        + lastnameField.getText() + "', EmailAddress = '" + emailField.getText() + "' WHERE PayPalUserID = " + user.getUuid());
                sql.executeUpdate(paypalUpdate);
            }
            
        }catch (SQLException sqle) 
        {
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
                
        
        shoppingCart.getCartHashMap().entrySet().forEach((product) -> {
            product.getKey().executeSQL("Update");
        });
   
        
    }
    
    public void addMembershipFee()
    {
        checkoutListPanel.remove(subtotalJPanel);
        checkoutListPanel.remove(taxJPanel);
        checkoutListPanel.remove(finalTotalPanel);
             

        /*Build member panel */
        buildJoinMembershipPanel();
        addSubtotal(19.95f);
 
        buildSubtotalPanel();

        buildTaxPanel();
        buildFinalTotalPanel();
        

        buildUClubRewardPanel();
        checkoutListPanel.repaint();
        checkoutListPanel.revalidate();

    }
    
    public void removeMembershipFee()
    {
        checkoutListPanel.remove(memberFeePanel);
        checkoutListPanel.remove(uclubRewardPanel);
        checkoutListPanel.remove(subtotalJPanel);
        checkoutListPanel.remove(finalTotalPanel);
        checkoutListPanel.remove(taxJPanel);
        removeSubtotal(19.95f);
        buildSubtotalPanel();
        buildTaxPanel();
        buildFinalTotalPanel();
        checkoutListPanel.repaint();
        checkoutListPanel.revalidate();
        
        
    }

    @Override
    public void reset() {
        
        checkoutListPanel.removeAll();

         firstnameField.setText("");
         middleinitalField.setText("");
         lastnameField.setText("");
         emailField.setText("");
        
    }
    
}
