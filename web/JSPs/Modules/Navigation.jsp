<%-- 
    Document   : Navigation
    Created on : 9 avr. 2015, 16:37:35
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sppp.business.Lien"%>
<%@page import="sppp.business.Version"%>
<%@page import="sppp.business.Document"%>
<%@page import="sppp.business.Logigram"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Logigram Nav_logigram = (Logigram) request.getAttribute("Logigram");
    if(Nav_logigram != null) 
    { 
        ArrayList<Lien> Nav_liens = Nav_logigram.Liens();
        if (Nav_liens != null) 
        {
            for(Lien lien : Nav_liens) 
            { 
                Document Nav_document = lien.Document;
                String Nav_nomDocument = Nav_document.DerniereVersion().NomFichier();
                //String Nav_cheminDocument = Nav_document.DerniereVersion().CheminRelatif();
                String Nav_href = "http://localhost:8084/PresentationSPPP /Home?Type=Document&ID="+Nav_document.ID;
%>                
                <a class="row" href="<%= Nav_href %>" target="_blank">  <%= Nav_nomDocument %> </a>
<%
            } 
        }
        else
        {
%>
            <div  class="row">Pas de documents liés</div>
<%
        }
    } 
%>
