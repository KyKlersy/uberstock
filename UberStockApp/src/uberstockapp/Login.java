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
    private int insertStatus;
    
    public Login()
    {
        
    }
    
    public boolean tryUserLogin()
    {
        
        executeSQL("Query");

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

        /* Ignore Test code for enum usage idea.
        
        try
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
    
    public boolean insertNewUser()
    {
        if(!"".equals(userName) && !"".equals(password))
            executeSQL("Insert");
        
        return insertStatus > 0;
        
        
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
    public void executeSQL(String commandType)
    {
        sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
        
        if(commandType == "Query")
        {
            query = ("SELECT UserID, Username, Password, Membership, AllowAdmin FROM USERS WHERE Username = '" + getUserName() + "' AND Password = '" + getPassword() + "'");
            setResults(sql.executeQuery(query));
        }
        else if(commandType == "Insert")
        {
            query = ("INSERT INTO Users(UserID, Username, Password, Membership, AllowAdmin) VALUES(NULL, '" + getUserName() + "','" + getPassword() + "', 1,0)");
            insertStatus = sql.executeUpdate(query);
        }

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
