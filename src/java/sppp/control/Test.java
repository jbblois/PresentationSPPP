/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sppp.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sppp.business.Extension;

/**
 *
 * @author user
 */
public class Test extends HttpServlet 
{
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        Extension extension = new Extension();
        extension.Nom = "TEST";
        request.setAttribute( "extension", extension );
        this.getServletContext().getRequestDispatcher( "/JSPs/Test.jsp" ).forward( request, response );
        
    }
}
