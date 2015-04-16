/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sppp.business.Extension;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class ExtensionDAO {
    
    public static Extension Select(int ID) 
    {
        
        Extension extension = null;
        
        String query =  "SELECT [Extension].[ID],[Extension].[Nom] " +
                        "FROM [Extension] " + 
                        "WHERE [Extension].[ID] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                extension = new Extension();
                extension.ID = rs.getInt("ID");
                extension.Nom = rs.getString("Nom");
            }
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return extension;
    }
}
