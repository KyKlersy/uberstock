/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;

import Enums.MembershipTypeEnum;
import java.util.ArrayList;

/**
 *
 * @author Kyle
 */
public class StandardUser extends UserAbstractBase{
    
    public StandardUser(String username, String password, int uuid, int membership, boolean allowAdmin) {
        super(username, password, uuid, membership, allowAdmin);
        
        for(MembershipTypeEnum membershipEnum : MembershipTypeEnum.values())
        {
            if(getMembership() == membershipEnum.getMembershipID())
            {
                setMembershipName(membershipEnum.getMembershipName());
            }
        }
    }
    
    @Override
    public void checkout(ArrayList<Product> shoppingList)
    {
        
        
        
        
    }
    
}
