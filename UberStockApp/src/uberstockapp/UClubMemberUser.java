/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;


/**
 *
 * @author Kyle
 */
public class UClubMemberUser extends UserAbstractBase{
    
    private float uClubReward;

    
    public UClubMemberUser(String username, String password, int uuid, int membership, boolean allowAdmin, float uClubReward) {
        super(username, password, uuid, membership, allowAdmin);
        this.uClubReward = uClubReward;

    } 


    
}
