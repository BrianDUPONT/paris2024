<%-- 
    Document   : listerAthletes
    Created on : 14 août 2024, 12:27:51
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Pays"%>
<%@page import="sio.paris2024.model.Sport"%>

<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
        <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
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
			<a  href ='../ServletAthlete/lister' class="navbar-brand" href=".">Listes des athlètes</a>
		</div>	
           </div>
	</nav>
        <%
                Athlete a = (Athlete)request.getAttribute("pAthlete");
        %>
        <div class="container special">
            <h2 class="h2"><%  out.println(a.getNom()); out.println(a.getPrenom());%></h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">  
                    <thead>
                        <tr>             
                            <th>id</th>
                            <th>pays</th>
                            <th>sport</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%  out.println(a.getId());%></td>
                            <td><%  out.println(a.getPays().getNom());%></td>
                            <td><%  out.println(a.getSport().getNom());%></td>
                        </tr>
                    </tbody>
            </table>
            </div>
        </div>
    </body>
</html>
