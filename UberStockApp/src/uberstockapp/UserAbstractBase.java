package uberstockapp;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public abstract class UserAbstractBase {
    
    
    private String Username;   
    private String Password;
    private int uuid;
    private int membership;
    private String membershipName;
    private boolean allowAdmin;
    
    
    public UserAbstractBase(String username, String password, int uuid, int membership, boolean allowAdmin)
    {
        setUsername(username);
        setPassword(password);
        setUuid(uuid);
        setMembership(membership);
        setAllowAdmin(allowAdmin);
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

    public final void setMembershipName(String membershipName)
    {
        this.membershipName = membershipName;
    }
    
    public final String getMembershipName()
    {
        return this.membershipName;
    }
    
    public void checkout(ArrayList<Product> shoppingList)
    {
        
    }
}
