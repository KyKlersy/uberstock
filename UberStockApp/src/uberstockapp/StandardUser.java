/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;



/**
 *
 * Concrete class for UserAbstractBase class
 * @author Kyle
 */
public class StandardUser extends UserAbstractBase{
    

    /**
     * Call UserAbstractBase Constructor
     * @param username
     * @param password
     * @param uuid
     * @param membership
     * @param allowAdmin 
     */
    
    public StandardUser(String username, String password, int uuid, int membership, boolean allowAdmin) {
        super(username, password, uuid, membership, allowAdmin);
        
        
        
        
    } 

}
