/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sppp.business.Document;
import sppp.business.Logigram;
import sppp.business.Version;
import sppp.persistance.DocumentDAO;
import sppp.persistance.LogigramDAO;
import sppp.util.Session;

/**
 *
 * @author user
 */
public class Home extends HttpServlet 
{
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        if (request.getQueryString() == null) 
        {
            GoAccueil(request, response);
        }
        else
        {
            String Type = request.getParameter("Type");
            if (Type != null) 
            {
                switch(Type)
                {
                    case "Logigram":
                        GoLogigram(request, response);
                        break;
                    case "Document":
                        GoDocument(request, response);
                        break;
                    default:
                        GoAccueil(request, response);
                        break;
                }
            }
            else
            {
                GoAccueil(request, response);
            }
            
        }
    }
    
    private void GoAccueil( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        request.setAttribute("Type", "Logigram");
        request.setAttribute("Logigram", LogigramDAO.Select("Accueil"));
        this.getServletContext().getRequestDispatcher( "/JSPs/Home.jsp" ).forward( request, response );
    }
    private void GoLogigram( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        try 
        {
            int logigramID = Integer.parseInt(request.getParameter("ID"));
            Logigram logigram = LogigramDAO.Select(logigramID);
            request.setAttribute("Logigram", logigram);
            this.getServletContext().getRequestDispatcher( "/JSPs/Home.jsp" ).forward( request, response );
        } catch (Exception e) 
        {
            GoAccueil(request, response);  
        }         
    }
    private void GoDocument( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        try 
        {
            int documentID = Integer.parseInt(request.getParameter("ID"));
            Document document = DocumentDAO.Select(documentID);
            this.getServletContext().getRequestDispatcher( document.DerniereVersion().CheminAbsolu()).forward( request, response );
        } catch (Exception e) 
        {
            GoAccueil(request, response);  
        }         
    }
}
