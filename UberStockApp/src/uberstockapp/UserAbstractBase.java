package uberstockapp;

import Enums.MembershipTypeEnum;
import Interfaces.SQL_Interface;
import java.sql.ResultSet;
import uberstockapp.database.sqlController;

/**
 *
 * This is abstract class for user 
 * including user and administration
 * @author carlo
 */
public abstract class UserAbstractBase{
    
    
    private String Username;   
    private String Password;
    private int uuid;
    private int membership;
    private String membershipName;
    private boolean allowAdmin;
    private final sqlController sql;
    
    
    /**
     * Constructor to set up user information
     * @param username
     * @param password
     * @param uuid
     * @param membership
     * @param allowAdmin 
     */
    public UserAbstractBase(String username, String password, int uuid, int membership, boolean allowAdmin)
    {
        setUsername(username);
        setPassword(password);
        setUuid(uuid);
        setMembership(membership);
        setAllowAdmin(allowAdmin);
        sql = (sqlController)ServiceLocator.getServiceLocatorInstance().getService("sqlController");

    }
    
    @Override
    public String toString()
    {
        return String.format("User: %s%nUuid#: %s%nMemberShip: %s%nAdmin: "
                ,getUsername(),getPassword(),getUuid(),getMembership(), getAllowAdmin());
    }
    
    public final void setUsername(String username)
    {
        this.Username = username;
    }

    public final void setPassword(String password)
    {
        this.Password = password;
    }
    
    public final void setAllowAdmin(Boolean allowAdmin)
    {
        
        this.allowAdmin = allowAdmin;
    }
    public final void setUuid(int uuid)
    {
        this.uuid = uuid;
        
    }
    public final void setMembership(int membership)
    {
        
        this.membership = membership;
        setMembershipName();
        
        
    } 
    
    public final String getUsername()
    {
        return this.Username;
    }
    public final String getPassword()
    {
        return this.Password;
    } 
    public final int getUuid()
    {
        return this.uuid;
    }
    public final boolean getAllowAdmin()
    {
        return this.allowAdmin;
    }
    public final int getMembership()
    {
        return this.membership; 
    }

    public final void setMembershipName()
    {
        for(MembershipTypeEnum membershipEnum : MembershipTypeEnum.values())
        {
            if(getMembership() == membershipEnum.getMembershipID())
            {
                this.membershipName = (membershipEnum.getMembershipName());
            }
        } 
    }
    
    public final String getMembershipName()
    {
        return this.membershipName;
    }

    /**
     * Update user information in database
     */
    public void updateUser()
    {
        String sqlUpdateCommand = "UPDATE USERS SET Username = '" + getUsername() + "',Password = '"+ getPassword() + "',Membership = " + getMembership() + " Where UserID = "+ getUuid();
        sql.executeUpdate(sqlUpdateCommand);
    }

}
