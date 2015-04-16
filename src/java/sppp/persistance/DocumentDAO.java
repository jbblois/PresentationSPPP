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
    public static Document Select(int ID)
    {
        Document document = null;
        
        String query =  "SELECT [Document].[ID],[Document].[FID_Categorie],[Document].[Nom],[Document].[Auteur] " +
                        "FROM [Document] " + 
                        "WHERE [Document].[ID] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                document = new Document();
                document.ID = rs.getInt("ID");
                document.Categorie = CategorieDAO.Select(rs.getInt("FID_Categorie"));
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
