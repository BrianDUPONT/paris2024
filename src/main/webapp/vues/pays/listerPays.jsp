<%-- 
    Document   : listerPays
    Created on : 9 septembre 2024, 10:30
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Pays"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
        <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
        
        <title>Paris 2024</title>

        <style>
            body {
		padding-top: 50px;
            }
                .special {
		padding-top:50px;
	}
        </style>
    </head>
    <body>
      
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a  href ='../ServletPays/lister' class="navbar-brand" href=".">Listes des pays participants</a>
			</div>
		</div>
	</nav>
    <body>
       <div class="container special">
            <h2 class="h2">Liste des pays</h2>
		<div class="table-responsive">
                <%
                    ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("aLesPays");
                %>
                <table class="table table-striped table-sm">  
                <thead>
                    <tr>             
                        <th>id</th>
                        <th>code</th>
                        <th>nom</th>               
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            for (Pays p : lesPays)
                            {              
                                out.println("<tr><td>");
                                out.println(p.getId());
                                out.println("</td>");

                                out.println("<td>");
                                out.println(p.getCode());
                                out.println("</a></td>");;      
                                
                                out.println("<td><a href ='../ServletPays/consulter?idPays="+ p.getId()+ "'>");
                                out.println(p.getNom());
                                out.println("</a></td></tr>");
                               
                            }
                        %>
                    </tr>
                </tbody>
            </table>
        </body>
         </div>
       </div>
  
</html>
