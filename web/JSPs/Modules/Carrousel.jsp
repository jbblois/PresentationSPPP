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
    Logigram Car_logigram = (Logigram) request.getAttribute("Logigram");
    if (Car_logigram != null) 
    {
       Logigram Car_previous = Car_logigram.Previous();
       String Car_hrefPrevious= "";
       String Car_nomPrevious = "Pas de logigramme précédent";
       if (Car_previous != null) 
       {
            Car_hrefPrevious= "./Home?Type=Logigram&ID="+Car_previous.ID;   
            Car_nomPrevious = Car_previous.DerniereVersion().NomFichier();
       }
%>
       <a class="col-md-6" href="<%= Car_hrefPrevious %>">  <%= Car_nomPrevious %> </a>
<%
        Logigram Car_next = Car_logigram.Next;
        String Car_hrefNext= "";
        String Car_nomNext = "Pas de logigramme suivant";
        if (Car_next != null) 
        {
            Car_hrefNext= "./Home?Type=Logigram&ID="+Car_next.ID;
            Car_nomNext = Car_next.DerniereVersion().NomFichier();
        }
       
%>
        <a class="col-md-6" href="<%= Car_hrefNext %>">  <%= Car_nomNext %> </a>
<%
    }

%>
