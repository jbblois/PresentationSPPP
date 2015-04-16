<%-- 
    Document   : Home
    Created on : 10 avr. 2015, 09:35:38
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sppp.business.Document"%>
<%@page import="sppp.util.Session"%>
<%@page import="sppp.business.Lien"%>
<%@page import="sppp.business.Version"%>
<%@page import="sppp.business.Logigram"%>
<%@page import="sppp.business.Extension"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="design/css/bootstrap.css" rel="stylesheet">
        <link href="design/css/base.css" rel="stylesheet">
        <title>ACCUEIL</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <div class="container">
            <div class="row"><!-- header -->
                <div class="col-md-12">
                    <%@include file="Modules/Header.jsp" %>
                </div>
            </div>
            <div class="row"> <!-- body -->
                <div class="col-md-3">
                    <%@include file="Modules/Navigation.jsp" %>
                </div>
                <div class="col-md-9">
                    <div class="row"><%@include file="Modules/Carrousel.jsp" %></div>
                    <div class="row"><%@include file="Modules/Main.jsp" %></div>  
                </div>
            </div>
                <div class="row"><!-- footer -->
                    <div class="col-md-12">
                        <%@include file="Modules/Footer.jsp" %>
                    </div>
                </div>
        </div>
    </body>
</html>
