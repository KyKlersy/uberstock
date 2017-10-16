/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Kyle
 */
public enum MembershipTypeEnum {
    //TEst
    StandardMember("Standard",1),
    UCMember("UberStock Club Member", 2);
    
    private final String membershipName;    
    private final int membershipID;

    private MembershipTypeEnum(String membershipName, int membershipID) 
    {
        this.membershipName = membershipName;
        this.membershipID = membershipID;
    }
    
    public String getMembershipName() {
        return membershipName;
    }

    public int getMembershipID() {
        return membershipID;
    }
    
}
