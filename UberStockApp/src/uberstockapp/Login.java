/**
 * this class handles the logging in of users by contacting the database and confirming the users
 * credentials.
 * 
 */
package uberstockapp;

import Interfaces.SQL_Interface;
import java.sql.ResultSet;
import java.sql.SQLException;
import uberstockapp.database.sqlController;

/**
 *
 * @author Kyle and Tri
 */
public class Login implements SQL_Interface{
    
    private String query;
    private ResultSet resultSet;
    private String userName;
    private String password;
    private int insertStatus;
    private boolean allowAdmin;
    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    
    public Login()
    { /* Default Constructor */
        
    }
    
    /**
     * function used to verify if user credentials are valid.
     * @return 
     */
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

                allowAdmin = resultSet.getBoolean("AllowAdmin");
                
                /*To do write code for handling which user class abstract to register as a service here*/
                /* ServiceLocator.getServiceLocatorInstance().registerService("User", new "Name of user concrete class"); */
                if(resultSet.getInt("Membership") == 0)
                {
                    /* Standard user */
                    serviceLocator.registerService("User", new StandardUser(resultSet.getString("Username"), 
                                                            resultSet.getString("Password"), resultSet.getInt("UserID"), 
                                                            resultSet.getInt("Membership"), resultSet.getBoolean("AllowAdmin")
                                                            ));
                    
                }
                else if(resultSet.getInt("Membership") == 1)
                {
                    /* Uclub member user*/
                    serviceLocator.registerService("User", new UClubMemberUser(resultSet.getString("Username"), 
                                                            resultSet.getString("Password"), resultSet.getInt("UserID"), 
                                                            resultSet.getInt("Membership"), resultSet.getBoolean("AllowAdmin"),
                                                            resultSet.getFloat("UclubReward")
                                                            ));
                }
                    
                System.out.println("UserName: " + resultSet.getString("UserName"));
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
 
       return false;
    }
    
    /**
     * method used to insert a new user when in the registration form.
     * @return 
     */
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
    
    public boolean getAdminRights()
    {
        return allowAdmin;
    }

    /**
     * SQL_Command Interface for being able to execute sql commands from elsewhere through the interface.
     * @param commandType 
     */
    @Override
    public void executeSQL(String commandType)
    {
        sqlController sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");
        
        if(commandType == "Query")
        {
            query = ("SELECT UserID, Username, Password, Membership, AllowAdmin, UclubReward FROM USERS WHERE Username = '" + getUserName() + "' AND Password = '" + getPassword() + "'");
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
