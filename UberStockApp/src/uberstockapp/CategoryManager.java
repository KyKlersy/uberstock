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
public class CategoryManager implements SQL_Interface{

    private final String query = "SELECT * FROM PRODUCTTYPE";
    private ResultSet resultSet;
    private ArrayList<Category> categoryList;
    
    public CategoryManager() 
    {
        categoryList = new ArrayList<>();
        buildCategoryList();
    }
    
    public final void buildCategoryList()
    {             
        try
        {    
            executeSQL("Query");
            
            while(resultSet.next())
            {
                categoryList.add(new Category(resultSet.getInt("ProductCatagory"), resultSet.getString("ProductGroupName")));

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
    
    public ArrayList<Category> getCategoryList()
    {
        return this.categoryList;
    }
    
    
    public void printList()
    {
        for(Category category : categoryList )
        {
            System.out.println("Category ID: " + category.getCategoryID() + " Categroy Name: " + category.getCategoryName());
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
