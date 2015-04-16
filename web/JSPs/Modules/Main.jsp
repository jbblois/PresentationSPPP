<%-- 
    Document   : Main
    Created on : 14 avr. 2015, 10:07:33
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sppp.business.Lien"%>
<%@page import="sppp.business.Version"%>
<%@page import="sppp.business.Document"%>
<%@page import="sppp.business.Logigram"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Logigram Main_logigram = (Logigram) request.getAttribute("Logigram");
    if(Main_logigram != null) { 
    String Main_cheminLogigram = Main_logigram.DerniereVersion().CheminRelatif();
%>  
<map name="logigramsMap">
    <% 
        ArrayList<Lien> Main_liens = Main_logigram.Liens();
        if (Main_liens != null) 
        {
            for(Lien lien : Main_liens) 
            { 
                String Main_coordonnees = lien.Coordonnees();
                String Main_hrefMap = "./Home?Type=";
                Document Main_document = lien.Document;
                if(Main_document.IsLogigram())
                {
                    Main_hrefMap += "Logigram&ID="+Main_document.ID;
                }
                else
                {
                    Main_hrefMap += "Document&ID="+Main_document.ID;
                }   
    %>
    <area shape="rect" coords="<%= Main_coordonnees %>" href="<%= Main_hrefMap %>" alt=""/>
    <%      
            } 
        }
    %>
</map>
    <img src="<%= Main_cheminLogigram %>" usemap="#logigramsMap" alt="" height="600" width="800"/>  
<%  } %>



