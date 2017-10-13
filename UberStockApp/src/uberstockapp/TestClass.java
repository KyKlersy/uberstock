/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import uberstockapp.database.sqlController;
import interfaces.SQL_Interface;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kyle
 */
public class TestClass {

    private final SQLCommand sqlc;

    
    
    public TestClass() {
        
        this.sqlc = new SQLCommand();
    }
    
    public void getMessage()
    {
        sqlc.getUsers();
        
            try
            {
                sqlc.getResultSet().next();
                int uuid = sqlc.getResultSet().getInt("UserID");
                String Username = sqlc.getResultSet().getString("UserName");
                String Password = sqlc.getResultSet().getString("Password");
                int membership = sqlc.getResultSet().getInt("Membership");
                int allowAdmin = sqlc.getResultSet().getInt("AllowAdmin");
                System.out.println("UUID: " + uuid + " username: " + Username + " password: " + Password + " membership: " + membership + " allowAdmin: " + allowAdmin );
                
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


    private final class SQLCommand implements SQL_Interface{
        
        private final String query = "SELECT UserID, Username, Password, Membership, AllowAdmin FROM USERS WHERE UserID = 0";
        private ResultSet resultSet;
        
        
        public SQLCommand() 
        { 
        }
        
        public void getUsers()
        {
            sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");

            setResults(sql.executeQuery(executeSQL()));

        }
        
        @Override
        public String executeSQL()
        {
            return query;
        }
        
        
        @Override
        public void setResults(ResultSet results)
        {
            
            this.resultSet = results;
            
        }
        
        public ResultSet getResultSet()
        {
            return this.resultSet;
        }
     
    }
 
};
    

