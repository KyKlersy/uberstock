/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;

/**
 *
 * @author Kyle
 */
public interface SQL_Interface {
    
    public void executeSQL(String commandType);
    
    public void setResults(ResultSet results);
  
}
