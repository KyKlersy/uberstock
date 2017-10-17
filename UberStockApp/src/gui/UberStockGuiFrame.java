/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import uberstockapp.Category;
import uberstockapp.CategoryManager;
import uberstockapp.Login;
import uberstockapp.Product;
import uberstockapp.ProductManager;
import uberstockapp.ProductPreviewController;
import uberstockapp.ProductViewController;
import uberstockapp.ServiceLocator;
import uberstockapp.ShoppingCart;


/**
 *
 * @author Kyle
 */
public class UberStockGuiFrame extends javax.swing.JFrame {
    
    //private HashMap<JButton, Product> productButtonMap;
    private HashMap<JButton, Category> categoryButtonMap;
    CardLayout cardLayout = null;
    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    /**
     * Creates new form UberStockGuiFrame
     */
    public UberStockGuiFrame() {
        initComponents();
        
        serviceLocator.registerService("ProductPreviewController", new ProductPreviewController(ItemPreviewImage, itemNameLbl, itemPriceLbl, currentStockLbl, cartQuantityToAddField));
        
        categoryButtonMap = new HashMap<>();
        CategoryManager categoryManager = new CategoryManager();
        
        int row = 0;
        int col = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.fill = SwingUtilities.HORIZONTAL;
        for(Category category : categoryManager.getCategoryList())
        {
            JButton button = new JButton();
            button.setText(category.getCategoryName());
            button.setPreferredSize(new Dimension(200, 100));
            button.setMinimumSize(new Dimension(200, 100));
            //button.setMargin(new Insets(5, 5, 5, 5));
            
            button.addActionListener((ae) -> {
                Category categoryClicked = categoryButtonMap.get((JButton)ae.getSource());
                System.err.println("Category Clicked: " + categoryClicked.getCategoryID());
                //Product view controller set view.
                ProductViewController productViewController = (ProductViewController)serviceLocator.getService("ProductViewController");
                productViewController.buildViewPanel(categoryClicked.getCategoryID(), productBtnGrid);
                repaint();
                revalidate();

//productScrollPanel.removeAll();
                
                //productScrollPanel.add(productViewController.setView(categoryClicked.getCategoryID()));
                //repaint();
                //revalidate();
            });
            
            
            categoryButtonMap.put(button, category);
            
            gridBagConstraints.gridx = row;
            gridBagConstraints.gridy = col;
            
            categoryControlPanel.add(button, gridBagConstraints);
            ++col;
        }
        
        ProductViewController productViewController = (ProductViewController)serviceLocator.getService("ProductViewController");
        //productViewController.buildViewPanel(0, productBtnGrid);
        

        
        
        /*productButtonMap = new HashMap<>();
        
        ProductManager productManager = (ProductManager)serviceLocator.getService("ProductManager");
        
        String imageURI = "../resources/imgs/";
        int row = 0;
        int col = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        for(Product product : productManager.getProductList())
        {

            String resourcePath = imageURI + product.getImageURI();
            //System.err.println("Image Resource Path: " + resourcePath);
            ImageIcon productImage = new ImageIcon(getClass().getResource(resourcePath));


            //Image image = ImageIO.read(ss().getResource("/resources/imgs/" + product.getImageURI());
            JButton button = new JButton();  //, productImage);

            button.setPreferredSize(new Dimension(350,350));
            button.setText(product.getName());
            button.setIcon(productImage);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setMinimumSize(new Dimension(250, 250));
            button.setPreferredSize(new Dimension(250, 250));
            button.setMargin(new Insets(5, 5, 5, 5));
            
            button.addActionListener((ae) -> {
                ShoppingCart shoppingCart = (ShoppingCart)serviceLocator.getService("ShoppingCart");
                Product clickedProduct = productButtonMap.get((JButton)ae.getSource());
                    System.out.println("Product Event Click Name: " + clickedProduct.getName() + " Image uri: " + product.getImageURI());


                    shoppingCart.setPreviewProduct(clickedProduct);
                    ItemPreviewImage.setIcon(new ImageIcon(getClass().getResource(imageURI + clickedProduct.getImageURI())));
                    itemNameLbl.setText(clickedProduct.getName());
                    itemPriceLbl.setText("$"+Float.toString(clickedProduct.getPrice()));
                    
                    //System.out.println(clickedProduct.getPrice());
                    currentStockLbl.setText(Integer.toString(clickedProduct.getQuantity()));
                    repaint();
                    revalidate();
            });

            productButtonMap.put(button, product);
            
            gridBagConstraints.gridx = row;
            gridBagConstraints.gridy = col;
            
            System.err.println("Column: " + col + " Row: " + row);
            productBtnGrid.add(button, gridBagConstraints);
            
            ++col;
            
            if(col % 3 == 0)
            {
                System.err.println("Col Mod 3 true: " + col);
                col = 0;
                ++row;
            }
            
            //System.out.println(product.getImageURI());
        }
        */    
        
        
        contentView.add(loginPanel, "1");
        contentView.add(storePanel, "2");
        contentView.add(registerPanel, "3");
        
        
        Dimension screenSize = getToolkit().getScreenSize();
        add(contentView);
        pack();
        //setResizable(false);
        setSize(screenSize.width,screenSize.height);
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
        productScrollPanel = new javax.swing.JScrollPane();
        productBtnGrid = new javax.swing.JPanel();
        cartScrollPanel = new javax.swing.JScrollPane();
        cartListPanel = new javax.swing.JPanel();
        uberStockNameLbl = new javax.swing.JLabel();
        paintPanel = new javax.swing.JPanel();
        storeBtn = new javax.swing.JButton();
        previewItemPanel = new javax.swing.JPanel();
        currentStockLbl = new javax.swing.JLabel();
        cartQuantityToAddField = new javax.swing.JTextField();
        currentStockText = new javax.swing.JLabel();
        quantityToAddText = new javax.swing.JLabel();
        ItemPreviewImage = new javax.swing.JLabel();
        itemPriceText = new javax.swing.JLabel();
        addToCartBtn = new javax.swing.JButton();
        cancelAddToCartBtn = new javax.swing.JButton();
        itemPriceLbl = new javax.swing.JLabel();
        itemNameLbl = new javax.swing.JLabel();
        shoppingCartPaintPanel = new javax.swing.JPanel();
        shoppingCartLbl = new javax.swing.JLabel();
        cartControlPanel = new javax.swing.JPanel();
        checkOutCartBtn = new javax.swing.JButton();
        clearCartBtn = new javax.swing.JButton();
        categoryControlPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UberStock");
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName("uberStockFrame"); // NOI18N
        setSize(new java.awt.Dimension(0, 0));

        contentView.setPreferredSize(new java.awt.Dimension(0, 0));
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
        storePanel.setMinimumSize(new java.awt.Dimension(800, 800));
        storePanel.setLayout(new java.awt.GridBagLayout());

        productScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        productScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        productScrollPanel.setMinimumSize(new java.awt.Dimension(300, 300));
        productScrollPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        productBtnGrid.setMinimumSize(new java.awt.Dimension(400, 400));
        productBtnGrid.setLayout(new java.awt.GridBagLayout());
        productScrollPanel.setViewportView(productBtnGrid);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        storePanel.add(productScrollPanel, gridBagConstraints);

        cartScrollPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        cartScrollPanel.setPreferredSize(new java.awt.Dimension(300, 300));

        cartListPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 2));
        cartScrollPanel.setViewportView(cartListPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 17, 0, 20);
        storePanel.add(cartScrollPanel, gridBagConstraints);

        uberStockNameLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        uberStockNameLbl.setForeground(new java.awt.Color(199, 32, 44));
        uberStockNameLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imgs/uberstockLogo.png"))); // NOI18N
        uberStockNameLbl.setText("UberStock");
        uberStockNameLbl.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        storePanel.add(uberStockNameLbl, gridBagConstraints);

        paintPanel.setBackground(new java.awt.Color(206, 209, 213));
        paintPanel.setMinimumSize(new java.awt.Dimension(450, 60));
        paintPanel.setPreferredSize(new java.awt.Dimension(400, 60));

        storeBtn.setText("Goto Login Panel");
        storeBtn.setPreferredSize(null);
        storeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paintPanelLayout = new javax.swing.GroupLayout(paintPanel);
        paintPanel.setLayout(paintPanelLayout);
        paintPanelLayout.setHorizontalGroup(
            paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paintPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(storeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        paintPanelLayout.setVerticalGroup(
            paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paintPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(storeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 19);
        storePanel.add(paintPanel, gridBagConstraints);

        previewItemPanel.setMinimumSize(new java.awt.Dimension(350, 350));
        previewItemPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        previewItemPanel.add(currentStockLbl, gridBagConstraints);

        cartQuantityToAddField.setMinimumSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        previewItemPanel.add(cartQuantityToAddField, gridBagConstraints);

        currentStockText.setText("Current Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        previewItemPanel.add(currentStockText, gridBagConstraints);

        quantityToAddText.setText("Quantity to Add");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        previewItemPanel.add(quantityToAddText, gridBagConstraints);

        ItemPreviewImage.setMaximumSize(new java.awt.Dimension(200, 200));
        ItemPreviewImage.setMinimumSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        previewItemPanel.add(ItemPreviewImage, gridBagConstraints);

        itemPriceText.setText("Item Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        previewItemPanel.add(itemPriceText, gridBagConstraints);

        addToCartBtn.setText("Add to Cart");
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        previewItemPanel.add(addToCartBtn, gridBagConstraints);

        cancelAddToCartBtn.setText("Cancel");
        cancelAddToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddToCartBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        previewItemPanel.add(cancelAddToCartBtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        previewItemPanel.add(itemPriceLbl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        previewItemPanel.add(itemNameLbl, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 20);
        storePanel.add(previewItemPanel, gridBagConstraints);

        shoppingCartPaintPanel.setBackground(new java.awt.Color(206, 209, 213));

        shoppingCartLbl.setText("jLabel1");

        javax.swing.GroupLayout shoppingCartPaintPanelLayout = new javax.swing.GroupLayout(shoppingCartPaintPanel);
        shoppingCartPaintPanel.setLayout(shoppingCartPaintPanelLayout);
        shoppingCartPaintPanelLayout.setHorizontalGroup(
            shoppingCartPaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartPaintPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(shoppingCartLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shoppingCartPaintPanelLayout.setVerticalGroup(
            shoppingCartPaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shoppingCartPaintPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(shoppingCartLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 20);
        storePanel.add(shoppingCartPaintPanel, gridBagConstraints);

        cartControlPanel.setLayout(new java.awt.GridBagLayout());

        checkOutCartBtn.setText("Checkout");
        checkOutCartBtn.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        cartControlPanel.add(checkOutCartBtn, gridBagConstraints);

        clearCartBtn.setText("Clear Cart");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        cartControlPanel.add(clearCartBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 18, 0, 20);
        storePanel.add(cartControlPanel, gridBagConstraints);

        categoryControlPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        categoryControlPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        storePanel.add(categoryControlPanel, gridBagConstraints);

        contentView.add(storePanel, "card3");

        getContentPane().add(contentView, java.awt.BorderLayout.CENTER);

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
            
            repaint();
            revalidate();
            
            
            
            
        }
        else
        {
            System.err.println("Login Failed.");
        }        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void storeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeBtnActionPerformed
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "1");
        revalidate();
    }//GEN-LAST:event_storeBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
 
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "3");
        revalidate();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void registerFormCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFormCancelBtnActionPerformed
        registerFormUsernameField.setText("");
        registerConfirmPassword.setText("");
        registerSecondConfirmPassword.setText("");
        
        cardLayout = (CardLayout)contentView.getLayout();
        cardLayout.show(contentView, "1");
        revalidate();
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
            revalidate();
        }
        else
        {
            System.err.println("Registration Error");
        }
        
        System.out.println("usernamelogin: " + login.getUserName() + " password set: " + login.getPassword());
    }//GEN-LAST:event_registerFormRegisterBtnActionPerformed

    
    private void cancelAddToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddToCartBtnActionPerformed
        ProductPreviewController productPreviewController = (ProductPreviewController)serviceLocator.getService("ProductPreviewController");
        ShoppingCart shoppingCart = (ShoppingCart)serviceLocator.getService("ShoppingCart");
                    productPreviewController.getItemImage().setIcon(null);
                    productPreviewController.getItemName().setText("");
                    productPreviewController.getItemPrice().setText("");
                    productPreviewController.getItemStock().setText("");
                    productPreviewController.getItemQuantity().setText("");
                    shoppingCart.setPreviewProduct(null);
        
    }//GEN-LAST:event_cancelAddToCartBtnActionPerformed

    
    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
        
       ShoppingCart shoppingCart = (ShoppingCart)serviceLocator.getService("ShoppingCart");
               
        shoppingCart.addCartItem(Integer.parseInt(cartQuantityToAddField.getText()), cartListPanel);
        
            repaint();
            revalidate();
        System.out.println(shoppingCart.toString());
        
    }//GEN-LAST:event_addToCartBtnActionPerformed



    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ItemPreviewImage;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JButton cancelAddToCartBtn;
    private javax.swing.JPanel cartControlPanel;
    private javax.swing.JPanel cartListPanel;
    private javax.swing.JTextField cartQuantityToAddField;
    private javax.swing.JScrollPane cartScrollPanel;
    private javax.swing.JPanel categoryControlPanel;
    private javax.swing.JButton checkOutCartBtn;
    private javax.swing.JButton clearCartBtn;
    private javax.swing.JPanel contentView;
    private javax.swing.JLabel currentStockLbl;
    private javax.swing.JLabel currentStockText;
    private javax.swing.JLabel itemNameLbl;
    private javax.swing.JLabel itemPriceLbl;
    private javax.swing.JLabel itemPriceText;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel paintPanel;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPanel previewItemPanel;
    private javax.swing.JPanel productBtnGrid;
    private javax.swing.JScrollPane productScrollPanel;
    private javax.swing.JLabel quantityToAddText;
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
