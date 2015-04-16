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
import sppp.business.Logigram;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class LogigramDAO {
    public static Logigram Select(int ID)
    {
        Logigram logigram = null;
        
        String query =  "SELECT [Logigram].[ID],Logigram.[FID_Next],[Document].[FID_Categorie],[Document].[Nom],[Document].[Auteur] " +
                        "FROM [Document] " +
                        "INNER JOIN [Logigram] ON [Logigram].[ID] = [Document].[ID] " +
                        "WHERE [Logigram].[ID] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                logigram = new Logigram();
                logigram.ID = rs.getInt("ID");
                logigram.Next = LogigramDAO.Select(rs.getInt("FID_Next"));
                logigram.Categorie = CategorieDAO.Select(rs.getInt("FID_Categorie"));
                logigram.Nom = rs.getString("Nom");
                logigram.Auteur = rs.getString("Auteur");
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
        
        return logigram;
    }
    public static Logigram Select(String Nom)
    {
        Logigram logigram = null;
        
        String query =  "SELECT [Logigram].[ID],[Logigram].[FID_Next],[Document].[FID_Categorie],[Document].[Nom],[Document].[Auteur] " +
                        "FROM [Document] " +
                        "INNER JOIN [Logigram] ON [Logigram].[ID] = [Document].[ID] " +
                        "WHERE [Document].[Nom] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setString(1, Nom);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                logigram = new Logigram();
                logigram.ID = rs.getInt("ID");
                logigram.Next = LogigramDAO.Select(rs.getInt("FID_Next"));
                logigram.Categorie = CategorieDAO.Select(rs.getInt("FID_Categorie"));
                logigram.Nom = Nom;
                logigram.Auteur = rs.getString("Auteur");
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
        
        return logigram;
    }

    public static Logigram PreviousLogigram(int ID_Previous) 
    {
        Logigram logigram = null;
        
        String query =  "SELECT [Logigram].[ID],Logigram.[FID_Next],[Document].[FID_Categorie],[Document].[Nom],[Document].[Auteur] " +
                        "FROM [Document] " +
                        "INNER JOIN [Logigram] ON [Logigram].[ID] = [Document].[ID] " +
                        "WHERE [Logigram].[FID_Next] = ?;";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID_Previous);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                logigram = new Logigram();
                logigram.ID = rs.getInt("ID");
                logigram.Next = LogigramDAO.Select(rs.getInt("FID_Next"));
                logigram.Categorie = CategorieDAO.Select(rs.getInt("FID_Categorie"));
                logigram.Nom = rs.getString("Nom");
                logigram.Auteur = rs.getString("Auteur");
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
        
        return logigram;
    }
}
