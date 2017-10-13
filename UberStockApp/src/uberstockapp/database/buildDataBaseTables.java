/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstockapp.database;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import org.hsqldb.cmdline.SqlFile;

/**
 *
 * @author Kyle
 */
public class buildDataBaseTables {
    
    static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private String DB_URI = "jdbc:hsqldb:file:";
    static final String USER = "SA";
    static final String PASS = "";
    private Connection connection = null;
    
    public buildDataBaseTables ()
    {

    }
    
    public final void buildTables()
    {
   
        try
        {
            Path relativePath = Paths.get("");
            String s = relativePath.toAbsolutePath().toString();
            s += "\\src\\uberstockapp\\database\\uberstockDB";
            System.out.println(s);
            
            DB_URI += s;
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(DB_URI, USER, PASS);
            String r = relativePath.toAbsolutePath().toString();
            r += "\\src\\resources\\buildTables.sql";
            File file = new File(r);
            SqlFile sqlFile = new SqlFile(file);
            sqlFile.setConnection(connection);
            sqlFile.execute();
            sqlFile.closeReader();
            connection.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void reBuildTables()
    {
        /* For later use will run specific code */
    }
    
    public void dropTables()
    {
        /* For later use will run specific code */
    }
    
}
