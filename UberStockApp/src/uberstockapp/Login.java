/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Enums.MembershipTypeEnum;
import interfaces.SQL_Interface;
import java.sql.ResultSet;
import java.sql.SQLException;
import uberstockapp.database.sqlController;

/**
 *
 * @author Kyle
 */
public class Login implements SQL_Interface{
    
    private String query;
    private ResultSet resultSet;
    private String userName;
    private String password;
    
    public Login()
    {
        
    }
    
    public boolean tryUserLogin()
    {
        
        executeSQL();

        try
        {
            if(!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                resultSet.next();
                
                /*To do write code for handling which user class abstract to register as a service here*/
                /* ServiceLocator.getServiceLocatorInstance().registerService("User", new "Name of user concrete class"); */
                
                
                System.out.println("UserName" + resultSet.getString("UserName"));
                return true;
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

        /*try
        {
            if(!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                resultSet.next();
                for(MembershipTypeEnum membershipEnum : MembershipTypeEnum.values())
                {
                    if(resultSet.getInt("Membership") == membershipEnum.getMembershipID())
                    {
                        System.out.println("ID matched:: " + membershipEnum.getMembershipID());
                    }
                }
                
                return true;
            }
            
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return false;
        }*/
       return false;
    }
    
    public void setLoginUserName(String UserName)
    {
        this.userName = UserName;
    }
    
    public void setLoginPassword(String Password)
    {
        this.password = Password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    


    @Override
    public void executeSQL()
    {
        sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
        query = ("SELECT UserID, Username, Password, Membership, AllowAdmin FROM USERS WHERE Username = '" + getUserName() + "' AND Password = '" + getPassword() + "'");
        setResults(sql.executeQuery(query));

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
