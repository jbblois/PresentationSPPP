/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.business;

import java.util.ArrayList;
import sppp.persistance.LienDAO;
import sppp.persistance.LogigramDAO;


/**
 *
 * @author user
 */
public class Logigram extends Document
{
    public Logigram Next;

    public Logigram() 
    {
    }
    
    public ArrayList<Lien> Liens()
    {
        return LienDAO.LinksOfLogigram(this);
    }
    
    public Logigram Previous()
    {
        return LogigramDAO.PreviousLogigram(ID);
    }
}
