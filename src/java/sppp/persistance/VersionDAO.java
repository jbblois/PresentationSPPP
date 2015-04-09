/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sppp.business.Document;
import sppp.business.Version;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class VersionDAO {
    public static Version Select(int Numero, Document Document) 
    {
        
        Version version = null;
        
        String query =  "SELECT [FID_Extension], [Date] " +
                        "FROM [Version] " + 
                        "WHERE [Numero] = ? " +
                        "AND [FID_Document] = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, Numero);
            ps.setInt(2, Document.ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                version = new Version();
                version.Numero = Numero;
                version.Document = Document;
                version.Extension = ExtensionDAO.Select(rs.getInt("FID_Extension"));
                version.Date = Base.StringToDate(rs.getString("Date"));
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
        
        return version;
    }
    
    public static Version LastVersion(Document Document) 
    {
        
        Version version = null;
        
        String query =  "SELECT Numero, [FID_Extension], [Date] " +
                        "FROM [Version] " +
                        "WHERE [FID_Document] = ? " +
                        "AND Numero =  " +
                        "( " +
                        "	SELECT MAX([Numero]) " +
                        "	FROM [Version] " +
                        "	WHERE [FID_Document] = ? " +
                        ")";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, Document.ID);
            ps.setInt(2, Document.ID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                version = new Version();
                version.Numero = rs.getInt("Numero");
                version.Document = Document;
                version.Extension = ExtensionDAO.Select(rs.getInt("FID_Extension"));
                version.Date = Base.StringToDate(rs.getString("Date"));
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
        
        return version;
    }
}
