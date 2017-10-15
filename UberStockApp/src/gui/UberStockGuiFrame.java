/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Button;
import java.awt.CardLayout;
import java.util.Arrays;
import javax.swing.JButton;
import uberstockapp.Login;
import uberstockapp.Product;
import uberstockapp.ProductManager;
import uberstockapp.ServiceLocator;


/**
 *
 * @author Kyle
 */
public class UberStockGuiFrame extends javax.swing.JFrame {
    
    CardLayout cardLayout = null;
    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    /**
     * Creates new form UberStockGuiFrame
     */
    public UberStockGuiFrame() {
        initComponents();
        
        contentView.add(loginPanel, "1");
        contentView.add(storePanel, "2");
        contentView.add(registerPanel, "3");
        
        ProductManager productManager = (ProductManager)serviceLocator.getService("ProductManager");
        
        
        
        for(Product product : productManager.getProductList())
        {
            
            productBtnGrid.add(new JButton(product.getName()));
            
            //System.out.println(product.getImageURI());
        }
        
        setVisible(true);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentView = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        passwordLbl = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        usernameLbl = new javax.swing.JLabel();
        UserNameField = new javax.swing.JTextField();
        registerPanel = new javax.swing.JPanel();
        registerFormRegisterBtn = new javax.swing.JButton();
        registerFormCancelBtn = new javax.swing.JButton();
        registerFormUsernameField = new javax.swing.JTextField();
        registerUsernameLbl = new javax.swing.JLabel();
        registerPasswordLbl = new javax.swing.JLabel();
        registerConfirmLbl = new javax.swing.JLabel();
        registerSecondConfirmPassword = new javax.swing.JPasswordField();
        registerConfirmPassword = new javax.swing.JPasswordField();
        storePanel = new javax.swing.JPanel();
        storeBtn = new javax.swing.JButton();
        productScrollPanel = new javax.swing.JScrollPane();
        productBtnGrid = new javax.swing.JPanel();
        cartScrollPanel = new javax.swing.JScrollPane();
        checkOutCartBtn = new javax.swing.JButton();
        uberStockNameLbl = new javax.swing.JLabel();
        paintPanel = new javax.swing.JPanel();
        clearCartBtn = new javax.swing.JButton();
        shoppingCartPaintPanel = new javax.swing.JPanel();
        shoppingCartLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UberStock");
        setName("uberStockFrame"); // NOI18N

        contentView.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(252, 252, 252));
        loginPanel.setLayout(new java.awt.GridBagLayout());

        loginBtn.setBackground(new java.awt.Color(206, 209, 213));
        loginBtn.setText("Login");
        loginBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        loginBtn.setMargin(new java.awt.Insets(4, 14, 4, 14));
        loginBtn.setMinimumSize(new java.awt.Dimension(78, 32));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 9, 0, 10);
        loginPanel.add(loginBtn, gridBagConstraints);

        registerBtn.setBackground(new java.awt.Color(206, 209, 213));
        registerBtn.setText("Register");
        registerBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 8);
        loginPanel.add(registerBtn, gridBagConstraints);

        passwordLbl.setText("Password :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        loginPanel.add(passwordLbl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        loginPanel.add(PasswordField, gridBagConstraints);

        usernameLbl.setText("User Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        loginPanel.add(usernameLbl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        loginPanel.add(UserNameField, gridBagConstraints);

        contentView.add(loginPanel, "card2");

        registerPanel.setBackground(new java.awt.Color(252, 252, 252));
        registerPanel.setLayout(new java.awt.GridBagLayout());

        registerFormRegisterBtn.setBackground(new java.awt.Color(206, 209, 213));
        registerFormRegisterBtn.setText("Register");
        registerFormRegisterBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        registerFormRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFormRegisterBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        registerPanel.add(registerFormRegisterBtn, gridBagConstraints);

        registerFormCancelBtn.setBackground(new java.awt.Color(206, 209, 213));
        registerFormCancelBtn.setText("Cancel");
        registerFormCancelBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        registerFormCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFormCancelBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 10);
        registerPanel.add(registerFormCancelBtn, gridBagConstraints);

        registerFormUsernameField.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        registerPanel.add(registerFormUsernameField, gridBagConstraints);

        registerUsernameLbl.setText("Username :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 47, 0, 0);
        registerPanel.add(registerUsernameLbl, gridBagConstraints);

        registerPasswordLbl.setText("Password :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 48, 0, 0);
        registerPanel.add(registerPasswordLbl, gridBagConstraints);

        registerConfirmLbl.setText("Confirm Password :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        registerPanel.add(registerConfirmLbl, gridBagConstraints);

        registerSecondConfirmPassword.setMinimumSize(new java.awt.Dimension(14, 24));
        registerSecondConfirmPassword.setPreferredSize(new java.awt.Dimension(14, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        registerPanel.add(registerSecondConfirmPassword, gridBagConstraints);

        registerConfirmPassword.setMinimumSize(new java.awt.Dimension(14, 24));
        registerConfirmPassword.setPreferredSize(new java.awt.Dimension(14, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        registerPanel.add(registerConfirmPassword, gridBagConstraints);

        contentView.add(registerPanel, "card4");

        storePanel.setBackground(new java.awt.Color(249, 250, 251));
        storePanel.setLayout(new java.awt.GridBagLayout());

        storeBtn.setText("Goto Login Panel");
        storeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        storePanel.add(storeBtn, gridBagConstraints);

        productScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        productScrollPanel.setMinimumSize(new java.awt.Dimension(250, 400));
        productScrollPanel.setPreferredSize(new java.awt.Dimension(250, 250));

        productBtnGrid.setLayout(new java.awt.GridLayout(1, 0, 5, 5));
        productScrollPanel.setViewportView(productBtnGrid);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        storePanel.add(productScrollPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 17, 0, 20);
        storePanel.add(cartScrollPanel, gridBagConstraints);

        checkOutCartBtn.setText("Checkout");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 50);
        storePanel.add(checkOutCartBtn, gridBagConstraints);

        uberStockNameLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        uberStockNameLbl.setForeground(new java.awt.Color(199, 32, 44));
        uberStockNameLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/uberstockLogo.png"))); // NOI18N
        uberStockNameLbl.setText("UberStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 85;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 50);
        storePanel.add(uberStockNameLbl, gridBagConstraints);

        paintPanel.setBackground(new java.awt.Color(206, 209, 213));
        paintPanel.setMinimumSize(new java.awt.Dimension(400, 60));
        paintPanel.setPreferredSize(new java.awt.Dimension(431, 60));

        javax.swing.GroupLayout paintPanelLayout = new javax.swing.GroupLayout(paintPanel);
        paintPanel.setLayout(paintPanelLayout);
        paintPanelLayout.setHorizontalGroup(
            paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );
        paintPanelLayout.setVerticalGroup(
            paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        storePanel.add(paintPanel, gridBagConstraints);

        clearCartBtn.setText("Clear Cart");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        storePanel.add(clearCartBtn, gridBagConstraints);

        shoppingCartPaintPanel.setBackground(new java.awt.Color(206, 209, 213));

        shoppingCartLbl.setText("jLabel1");

        javax.swing.GroupLayout shoppingCartPaintPanelLayout = new javax.swing.GroupLayout(shoppingCartPaintPanel);
        shoppingCartPaintPanel.setLayout(shoppingCartPaintPanelLayout);
        shoppingCartPaintPanelLayout.setHorizontalGroup(
            shoppingCartPaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartPaintPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(shoppingCartLbl)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        shoppingCartPaintPanelLayout.setVerticalGroup(
            shoppingCartPaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartPaintPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(shoppingCartLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 21);
        storePanel.add(shoppingCartPaintPanel, gridBagConstraints);

        contentView.add(storePanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentView, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
        Login login = (Login)serviceLocator.getService("Login");
        login.setLoginUserName(UserNameField.getText());
        login.setLoginPassword(String.valueOf(PasswordField.getPassword()));
        
        System.out.println("usernamelogin: " + login.getUserName() + " password set: " + login.getPassword());
        
        if(login.tryUserLogin())
        {
            UserNameField.setText("");
            PasswordField.setText("");
            cardLayout = (CardLayout)contentView.getLayout();
            cardLayout.show(contentView, "2");
        }
        else
        {
            System.err.println("Login Failed.");
        }        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void storeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeBtnActionPerformed
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "1");
    }//GEN-LAST:event_storeBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
 
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "3");
    }//GEN-LAST:event_registerBtnActionPerformed

    private void registerFormCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFormCancelBtnActionPerformed
        registerFormUsernameField.setText("");
        registerConfirmPassword.setText("");
        registerSecondConfirmPassword.setText("");
        
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "1");
    }//GEN-LAST:event_registerFormCancelBtnActionPerformed

    private void registerFormRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFormRegisterBtnActionPerformed
        Login login = (Login)serviceLocator.getService("Login");
        login.setLoginUserName(registerFormUsernameField.getText());
        login.setLoginPassword(String.valueOf(registerConfirmPassword.getPassword()));
        
        if(login.insertNewUser())
        {
            registerFormUsernameField.setText("");
            registerConfirmPassword.setText("");
            registerSecondConfirmPassword.setText("");
            
            login.tryUserLogin();
            cardLayout = (CardLayout)contentView.getLayout();
            cardLayout.show(contentView, "2");
        }
        else
        {
            System.err.println("Registration Error");
        }
        
        System.out.println("usernamelogin: " + login.getUserName() + " password set: " + login.getPassword());
    }//GEN-LAST:event_registerFormRegisterBtnActionPerformed



    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JScrollPane cartScrollPanel;
    private javax.swing.JButton checkOutCartBtn;
    private javax.swing.JButton clearCartBtn;
    private javax.swing.JPanel contentView;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel paintPanel;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPanel productBtnGrid;
    private javax.swing.JScrollPane productScrollPanel;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel registerConfirmLbl;
    private javax.swing.JPasswordField registerConfirmPassword;
    private javax.swing.JButton registerFormCancelBtn;
    private javax.swing.JButton registerFormRegisterBtn;
    private javax.swing.JTextField registerFormUsernameField;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel registerPasswordLbl;
    private javax.swing.JPasswordField registerSecondConfirmPassword;
    private javax.swing.JLabel registerUsernameLbl;
    private javax.swing.JLabel shoppingCartLbl;
    private javax.swing.JPanel shoppingCartPaintPanel;
    private javax.swing.JButton storeBtn;
    private javax.swing.JPanel storePanel;
    private javax.swing.JLabel uberStockNameLbl;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
