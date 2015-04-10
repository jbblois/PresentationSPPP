<%-- 
    Document   : Index
    Created on : 10 avr. 2015, 09:35:38
    Author     : user
--%>

<%@page import="sppp.business.Extension"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="design/css/bootstrap.css" rel="stylesheet">
        <link href="design/css/base.css" rel="stylesheet">
        <title>JSP TEST</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <div class="container">
      <header class="row">
        <div class="col-lg-12">
          <%@include file="Modules/Header.jsp" %>
        </div>
      </header>
      <div class="row">
        <nav class="col-lg-2">
          <%@include file="Modules/Navigation.jsp" %>
        </nav>
        <section class="col-lg-10">
            <% 
                out.println( ((Extension)request.getAttribute("extension")).Nom );
            %>
        </section>
      </div>
      <footer class="row">
          <%@include file="Modules/Footer.jsp" %>
      </footer>
    </div>
  </body>
</html>
