/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sppp.business.Document;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class DocumentDAO 
{
    public static Document Select(Integer ID)
    {
        Document document = null;
        
        String query =  "SELECT [ID], [FID_Categorie], [Nom], [Auteur] " +
                        "FROM [Document] " + 
                        "WHERE [ID] = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                document = new Document();
                document.ID = ID;
                //document.setDirectoryName(rs.getString("DirectoryName"));
                document.Categorie = CategorieDAO.Select(rs.getInt("FID_Category"));
                document.Nom = rs.getString("Nom");
                document.Auteur = rs.getString("Auteur");
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
        
        return document;
    }
}
