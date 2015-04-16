/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.business;

import java.math.BigInteger;
import sppp.persistance.LogigramDAO;
import sppp.persistance.VersionDAO;
import sppp.util.Base;

/**
 *
 * @author user
 */
public class Document 
{
    public int ID;
    public Categorie Categorie;
    public String Nom;
    public String Auteur;

    public Document() 
    {
    }
    
    public String CheminRelatif()
    {
        return Base.FILEBASE_PATH + '/' + this.Categorie.Nom+ '/' + this.Nom;
    }
    public String CheminAbsolu()
    {
        return "/FileBase/" + this.Categorie.Nom+ '/' + this.Nom;
    }
    public Version DerniereVersion()
    {
        return VersionDAO.LastVersion(this);
    }
    public Boolean IsLogigram()
    {
        return LogigramDAO.Select(ID) != null;
    }
}
