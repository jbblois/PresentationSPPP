/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import org.eclipse.jdt.internal.compiler.impl.Constant;

/**
 *
 * @author user
 */
public abstract class Base 
{
    private static final String DATABASE_TYPE = "jtds:sqlserver";
    private static final String DATABASE_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
    private static Connection connection;
    
    private static final String DATABASE_IP = "localhost";
    private static final String DATABASE_PORT = "1433";
    private static final String DATABASE_URL = "jdbc:"+DATABASE_TYPE+"://"+DATABASE_IP+":"+DATABASE_PORT+"/PresentationSPPP/";
    private static final String DATABASE_LOGIN = "sa";
    private static final String DATABASE_PASSWORD = "not24get";
    
    public static final String FILEBASE_PATH = "./FileBase";
    
    public static Connection GetConnection() {
        
        if (connection == null) 
        {
            try 
            {
                Class.forName(DATABASE_DRIVER);
            } 
            catch (ClassNotFoundException ex) 
            {
               ex.printStackTrace();
            }

            try 
            {
                connection = DriverManager.getConnection(DATABASE_URL,DATABASE_LOGIN,DATABASE_PASSWORD);       
            }
            catch (SQLException ex) 
            {
                ex.printStackTrace();
                return null;
            }
            catch (Exception exc) {
                exc.printStackTrace();
                return null;
            }
        }
        
        return connection;
    }
    
    /**
     * Close the connection to the database
     */
    public static void CloseConnection() {
        
        if(connection != null) {
            try {
                connection.close();
                connection = null;
            }
            catch(Exception exc) {
                exc.printStackTrace();
            }
        }
    }
    
    
    public static Date StringToDate(String DateTime)
    {
        Date date = new Date();
        String[] split = DateTime.split(" ")[0].split("-");
        date.setDate(Integer.parseInt(split[2]));
        date.setMonth(Integer.parseInt(split[1]));
        date.setYear(Integer.parseInt(split[0]));
        return date;
    }
}
