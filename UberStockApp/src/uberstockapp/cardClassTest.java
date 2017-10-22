/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author Kyle and Tri
 */
public class cardClassTest {
    
    JFrame frame = new JFrame("MultipleViews");
    JPanel panelView = new JPanel();
    JPanel loginPanel = new JPanel();
    JPanel storePanel = new JPanel();
    
    JButton buttonOne = new JButton("Switch to Store panel");
    JButton buttonSecond = new JButton("Switch to Login panel");
    
    CardLayout cardLayout = new CardLayout();
    
    public cardClassTest()
    {
        panelView.setLayout(cardLayout);
        loginPanel.add(buttonOne);
        storePanel.add(buttonSecond);
        
        loginPanel.setBackground(Color.BLUE);
        storePanel.setBackground(Color.GREEN);
        
        panelView.add(loginPanel, "1");
        panelView.add(storePanel, "2");
        
        cardLayout.show(panelView, "1");
        
        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelView, "2");
            }
        });

        buttonSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.show(panelView, "1");
            }
        });
        
        frame.add(panelView);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    
    
}
