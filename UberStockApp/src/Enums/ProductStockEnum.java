/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author tri.le
 */
public enum ProductStockEnum {
    NotAvailable("Not Available",0) ;
    private final String status;
    private final int stockValue;

    private ProductStockEnum(String status, int stockValue) {
        this.status = status;
        this.stockValue = stockValue;
    }
    public String getStatus(){
        return this.status;
    }            
    public int getValue(){
        return this.stockValue;
    }
}
