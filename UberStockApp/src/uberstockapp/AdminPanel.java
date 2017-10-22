/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import uberstockapp.database.sqlController;

/**
 *
 * @author Kyle
 */
public class AdminPanel {

    ServiceLocator serviceLocator = ServiceLocator.getServiceLocatorInstance();
    sqlController sql = (sqlController)serviceLocator.getService("sqlController");

    private JTable dataTable;
    private JButton searchButton;
    private JTextField userIDField;
    
    public AdminPanel(JTable dataTable, JButton searchButton, JTextField userIDField) {
        this.dataTable = dataTable;
        this.searchButton = searchButton;
        this.userIDField = userIDField;
        
    }
    
    public void getUserHistory()
    {

        
            String query;
            query = ("SELECT USERS.USERNAME, INVENTORYITEMS.ITEMNAME, INVENTORYITEMS.ITEMPRICE, PURCHASEHISTORY.ITEMAMOUNT\n" +
                     "FROM PURCHASEHISTORY\n" +
                     "JOIN INVENTORYITEMS ON INVENTORYITEMS.ITEMID = PURCHASEHISTORY.ITEMID\n" +
                     "JOIN USERS ON USERS.USERID = PURCHASEHISTORY.PURCHASEUSERID\n"
                    +"WHERE PURCHASEHISTORY.PURCHASEUSERID = " + Integer.parseInt(userIDField.getText()));
            
            System.err.println(Integer.parseInt(userIDField.getText()));
            ResultSet resultSet = sql.executeQuery(query);
            
        try
        {
            dataTable.setModel(buildTable(resultSet));
        }
        catch (SQLException sqle) 
        {
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
     
    }
    
    private DefaultTableModel buildTable(ResultSet resultSet)
            throws SQLException
    {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
        
        
    
    
    
    
}
