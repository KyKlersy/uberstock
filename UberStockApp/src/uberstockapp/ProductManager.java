/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;
import interfaces.SQL_Interface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uberstockapp.database.sqlController;

/**
 *
 * @author Kyle
 */
public class ProductManager implements SQL_Interface
{
    private final String query = "SELECT * FROM INVENTORYITEMS";
    private ResultSet resultSet = null;
    private ArrayList<Product> productList;

    public ProductManager() 
    {
        buildProductList();
    }
    
    public final void buildProductList()
    {
        productList = new ArrayList<>();
                
        try
        {    
            executeSQL("Query");
            
            while(resultSet.next())
            {
                productList.add(new Product(resultSet.getInt("itemID"), resultSet.getString("itemName"), resultSet.getInt("itemCatagory"), resultSet.getFloat("itemPrice"), resultSet.getInt("itemStock"), resultSet.getString("itemImageURI")));

            }
        }
        catch (SQLException sqle) 
        {
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
        
        
    }
    
    public ArrayList<Product> getProductList()
    {
        return this.productList;
    }
    
    
    public void printList()
    {
        for(Product product : productList )
        {
            System.out.println("Product ID:: " + product.getProductID() + "Product Name:: " + product.getName());
        }
        
    }

    @Override
    public void executeSQL(String commandType) 
    {
        if(commandType == "Query")
        {
            sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
            setResults(sql.executeQuery(query));
        }

    }

    @Override
    public void setResults(ResultSet results) {
        this.resultSet = results;
    }

}
