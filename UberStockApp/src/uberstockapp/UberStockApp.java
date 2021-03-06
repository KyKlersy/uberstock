/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;
import gui.UberStockGuiFrame;
import javax.swing.SwingUtilities;
import uberstockapp.database.buildDataBaseTables;
import uberstockapp.database.sqlController;
/**
 *
 * @author Kyle
 * this is a commit.
 */
public class UberStockApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*********************************************************************/
        /* Singleton Service locator, is used to register all classess created in
        /* the main body of our program, it is used as a way for classess to communicate
        /* and get references to other components that they may need.
        /* in practice you should not have a god class such as this as it can lead to messy code
        /* but for simplicity sake since this is a small project it is fine.
        /* 
        /* Any class you create should use default constructors and be registered to the service locator
        /* see code block below with Service locator Registration.
        /*
        /*
        */
        ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();

        /************************************************************************************************************************************/
        /*  Registering a class into the service locator, first parameter is a string name to find the serbice by, use the class name,      */
        /*        second parameter is the class object itself, your classess should be constructed like below with default constructors     */
        /************************************************************************************************************************************/
        serviceLocator.registerService("sqlController", new sqlController());
        serviceLocator.registerService("ProductManager", new ProductManager());
        serviceLocator.registerService("ProductViewController", new ProductViewController());
        serviceLocator.registerService("CategoryManager", new CategoryManager());
        serviceLocator.registerService("Login", new Login());
        serviceLocator.registerService("ShoppingCart", new ShoppingCart());
        
        /*********************************************************************/
        /* This block here builds the database, you only need to run it once */
        /* to build the tables, its fine to leave it uncommented after it has*/
        /* been run once, but it will constantly wipe and rebuild the tables */
        /* should you wish it to not do that comment out the lines below     */
        /* It will be changed in the final version of our project so that    */
        /* Tables are created only once, but currently setup to wipe each    */
        /* time for testing purposes on my end.                              */
        /*********************************************************************/
            buildDataBaseTables bdt = new buildDataBaseTables();
            if(!bdt.databaseExists())
            {
                bdt.buildTables();
            }
            
        /*End block*/
        

        

        /* Constructing the GUI Frame */
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                new UberStockGuiFrame();
            }
        });
        
    }
    
}
