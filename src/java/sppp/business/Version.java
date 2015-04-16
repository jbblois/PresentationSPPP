/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.business;

import java.util.Date;

/**
 *
 * @author user
 */
public class Version 
{
    public int Numero;
    public Document Document;
    public Extension Extension;
    public Date Date;
    public Version() 
    {
    }
    public String NomFichier()
    {
        return Document.Nom+'_'+Date.getYear()+'-'+Date.getMonth()+'-'+Date.getDate()+'.'+Extension.Nom;
    }
    public String CheminRelatif()
    {
        return Document.CheminRelatif()+'/'+NomFichier();
    }
    public String CheminAbsolu()
    {
        return Document.CheminAbsolu()+'/'+NomFichier();
    }
}
