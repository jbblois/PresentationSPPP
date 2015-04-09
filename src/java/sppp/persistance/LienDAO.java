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
import sppp.business.Lien;
import sppp.business.Logigram;
import sppp.util.Base;

/**
 *
 * @author user
 */
public abstract class LienDAO 
{
    public static Lien Select(Integer ID)
    {
        Lien lien = null;
        
        String query =  "SELECT [ID], [FID_Logigram], [FID_Document], [X1], [Y1], [X2], [Y2] " +
                        "FROM [Lien] " + 
                        "WHERE [ID] = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                lien = new Lien();
                lien.ID = ID;
                lien.Logigram = LogigramDAO.Select(rs.getInt("FID_Logiram"));
                lien.Document = DocumentDAO.Select(rs.getInt("FID_Document"));
                lien.X1 = rs.getInt("X1");
                lien.Y1 = rs.getInt("Y1");
                lien.X2 = rs.getInt("X2");
                lien.Y2 = rs.getInt("Y2");
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
        
        return lien;
    }
    public static ArrayList<Lien> LinksOfLogigram(Logigram Logigram) 
    {
        
        ArrayList<Lien> liens = null;
        
        String query =  "SELECT ID, [FID_Document], [X1], [Y1], [X2], [Y2] " +
                        "FROM [Lien] " + 
                        "WHERE [FID_Logigram] = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Base.GetConnection().prepareStatement(query);
            ps.setInt(1, Logigram.ID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Lien lien = new Lien();
                lien.ID = rs.getInt(("ID"));
                lien.Logigram = Logigram;
                lien.Document = DocumentDAO.Select(rs.getInt("FID_Document"));
                lien.X1 = rs.getInt("X1");
                lien.Y1 = rs.getInt("Y1");
                lien.X2 = rs.getInt("X2");
                lien.Y2 = rs.getInt("Y2");
                
                if(liens == null) {
                    liens = new ArrayList<>();
                }
                
                liens.add(lien);
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
        
        return liens;
    }
}
