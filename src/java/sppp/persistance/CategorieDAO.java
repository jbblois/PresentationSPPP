/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.persistance;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sppp.business.Categorie;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class CategorieDAO 
{
    public static Categorie Select(int ID) 
    {
        
        Categorie categorie = null;
        
        String query = "SELECT [Categorie].[ID],[Categorie].[Nom] "
                     + "FROM [Categorie] "
                     + "WHERE [Categorie].[ID] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                categorie = new Categorie();
                categorie.ID = rs.getInt("ID");
                categorie.Nom = rs.getString("Nom");
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
        
        return categorie;
    }
}
