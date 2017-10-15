/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp.database;

import java.sql.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Kyle
 */
public class sqlController {
    
static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private String DB_URI = "jdbc:hsqldb:file:";

    
    /*  "jdbc:hsqldb:file:K:\\LargeMyDocs\\Java Projects\\hsqldbTest\\src\\hsqldbtest";  */
    static final String USER = "SA";
    static final String PASS = "";
    

    public sqlController() 
    {

        Path relativePath = Paths.get("");
        String s = relativePath.toAbsolutePath().toString();
        s += "\\src\\uberstockapp\\database\\uberstockDB";

        DB_URI += s;

        System.out.println(DB_URI);     
            
    }
    
    public ResultSet executeQuery(String query)
    {

        try
        {

            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection connection = DriverManager.getConnection(DB_URI, USER, PASS);
            
            Statement stmt = connection.createStatement();
            String sqlCommand;
            System.out.println("Pass sql " + query);
                   
            sqlCommand = query;
            ResultSet resultSet = stmt.executeQuery(sqlCommand);

            stmt.close();
            connection.close();
            
            return resultSet;
            
        } 
        catch (SQLException sqle) 
        {
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return  null;
    }
    
    public int executeUpdate(String query) 
    {
        try
        {
            int insertStatus;
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection connection = DriverManager.getConnection(DB_URI, USER, PASS);
            
            Statement stmt = connection.createStatement();
            String sqlCommand;
            System.out.println("Pass sql " + query);
                   
            sqlCommand = query;
            insertStatus = stmt.executeUpdate(sqlCommand);

            stmt.close();
            connection.close();
            
            return insertStatus;
            
        } 
        catch (SQLException sqle) 
        {
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return -1;
    }
}
